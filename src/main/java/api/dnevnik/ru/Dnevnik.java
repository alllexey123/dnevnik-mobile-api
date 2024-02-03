package api.dnevnik.ru;

import api.dnevnik.ru.exceptions.DnevnikApiException;
import api.dnevnik.ru.model.request.*;
import api.dnevnik.ru.model.response.BasicResponse;
import api.dnevnik.ru.model.response.EsiaLinkedUsersResponse;
import api.dnevnik.ru.model.response.EsiaLoginResponse;
import api.dnevnik.ru.model.response.EsiaRegionsResponse;
import api.dnevnik.ru.model.response.feed.FeedResponse;
import api.dnevnik.ru.model.response.info.*;
import api.dnevnik.ru.model.response.marks.FinalMarksResponse;
import api.dnevnik.ru.model.response.marks.PeriodMarksResponse;
import api.dnevnik.ru.model.response.marks.SubjectDetailsResponse;
import api.dnevnik.ru.providers.AccessTokenProvider;
import api.dnevnik.ru.storage.Storage;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <p>This is the main class for Java Dnevnik Ru API.
 * It uses the {@link DnevnikApi} class (by default made via Retrofit) to access Mobile Dnevnik Ru API.<br></p>
 * <p>Each Dnevnik object represents a single student profile.
 * It automatically saves credentials and user data to {@link Storage} to use in future requests.</p>
 * <br>
 * <h2>Creating Dnevnik client</h2>
 * <p>There are several ways to create a new Dnevnik instance based on your needs.</p>
 * <ul>
 *     <li>
 *         Using the {@link Dnevnik#newInstance()}. One-liner to create a default instance of the Dnevnik.
 *     </li>
 *     <li>
 *         Using the {@link DnevnikBuilder}. You can change the Gson, OkHttpClient and Retrofit used to create the {@link Dnevnik#api}.
 *         Also it is possible to create custom {@link Storage} implementation.
 *     </li>
 *     <li>
 *         Using the {@link Dnevnik#Dnevnik(DnevnikApi, Storage)}. Pretty much the same as above,
 *         but you need to create a custom {@link DnevnikApi} and {@link Storage}.
 *     </li>
 *     <li>
 *         Extending this class and overriding its values and methods. Suitable for maximum customization.
 *     </li>
 * </ul>
 * <p><strong>Note: {@link Dnevnik#storage} is runtime only by default, so you should make custom implementation to preserve
 * data such as tokens, user IDs, etc.</strong></p>
 * <br>
 * <h2>Authentication</h2>
 * <p>There are two ways to authenticate:</p>
 * <ul>
 *     <li>
 *         Through <a href="https://login.dnevnik.ru/login">Dnevnik Ru</a> username and password using the
 *         {@link Dnevnik#auth(String username, String password)} method.
 *         This is the easiest way to authenticate.
 *     </li>
 *     <li>
 *         Through <a href="https://esia.gosuslugi.ru/login/">ESIA</a> task id and region id using the {@link Dnevnik#esiaAuth(String taskId, int regionId)}
 *         This method is harder to use, because it requires browser emulation (such as <a href="https://playwright.dev/">Playwright</a>)
 *         and passing two-step verification, but here are the steps to successfully authenticate:
 *         <ol>
 *             <li>Call {@link Dnevnik#getEsiaRegions()} and get the URL and ID of the region;
 *             <li>Using a browser (or an emulator) authorize through the URL, after completing last step you should see the task id;
 *             <li>Pass the task id and region id to {@link Dnevnik#esiaAuth};
 *             Under the hood, this method retrieves the user associated with the task using {@link DnevnikApi#getEsiaLinkedUsers}
 *             and gets the credentials using {@link DnevnikApi#esiaLogin};
 *             <li>Done.
 *         </ol>
 *     </li>
 * </ul>
 * <h2>API Methods</h2>
 * <p>Many methods require Profile ID and Group ID. To get them you might need to use {@link Dnevnik#updateUserContext()} after authentication,
 * or preserve these values somewhere, such as database, and create custom {@link Storage} implementation.</p>
 * <strong>Note: the comment of each of the methods below contains the necessary fields for successful execution.</strong>
 */
public class Dnevnik implements IDnevnik, AccessTokenProvider {

    public static final String API_URL = "https://api.dnevnik.ru/";

    protected DnevnikApi api;

    protected Storage storage;

    public Dnevnik(DnevnikApi api, Storage storage) {
        this.api = api;
        this.storage = storage;
    }

    /**
     * Creates a new default Dnevnik instance.
     * @return new dnevnik instance
     */
    public static Dnevnik newInstance() {
        return new DnevnikBuilder().build();
    }

    /**
     * Authenticates via student login and password. Saves the received credentials to a storage for later use in other methods.
     * @param username the student username
     * @param password the student password
     * @return login response with credentials
     * @throws DnevnikApiException if an error occurs
     */
    public LoginResponse auth(@NotNull String username, @NotNull String password) throws DnevnikApiException {
        LoginRequest request = LoginRequest.builder()
                .username(username)
                .password(password).build();
        LoginResponse response = executeSync(api().login(request));
        storage.setCredentials(response.getCredentials());
        return response;
    }

    /**
     * Authenticates via student esia task ID and region ID. Saves the received credentials to a storage for later use in other methods.
     * <br><br>
     * <strong>Note: the esia task ID can be obtained after authenticating with the link provided by the {@link Dnevnik#getEsiaRegions()}
     * method. Region IDs are also provided by this method.</strong>
     * @param esiaTaskId esia task id
     * @param regionId student region id
     * @return login response with credentials
     * @throws DnevnikApiException if an error occurs
     */
    public ExtendedCredentials esiaAuth(@NotNull String esiaTaskId, int regionId) throws DnevnikApiException {
        EsiaTaskWrapper esiaTaskWrapper = EsiaTaskWrapper.builder()
                .taskId(esiaTaskId)
                .regionId(regionId).build();
        EsiaLinkedUsersResponse linkedUsersResponse = executeSync(api().getEsiaLinkedUsers(esiaTaskWrapper));
        List<User> users = linkedUsersResponse.getUsers();
        if (users.isEmpty()) throw new DnevnikApiException("No users linked to esia task");
        User user = users.get(0);
        EsiaLoginRequest loginRequest = EsiaLoginRequest.builder()
                .userId(user.getUserId())
                .taskId(esiaTaskId)
                .regionId(regionId).build();
        EsiaLoginResponse loginResponse = executeSync(api().esiaLogin(loginRequest));
        ExtendedCredentials authorization = loginResponse.getAuthorization();
        storage.setExtendedCredentials(authorization);
        return authorization;
    }

    /**
     * @return the list of regions to be used for esia authentication
     * @throws DnevnikApiException if an error occurs
     */
    public EsiaRegionsResponse getEsiaRegions() throws DnevnikApiException {
        return executeSync(api().getEsiaRegions());
    }

    /**
     * Updates and saves user context using credentials from the storage.
     * <br>User context contains field like school id, person id and group id, which are used in other methods.
     * <br><strong>Requires: access token and user id</strong>
     * @return user context
     * @throws DnevnikApiException if an error occurs
     */
    public UserContext updateUserContext() throws DnevnikApiException {
        UserContext userContext = executeSync(api().getUserContext(getOrUpdateAccessToken(), storage.getUserId()));
        storage.setUserContext(userContext);
        return userContext;
    }

    /**
     * Validates payment done though google or apple service.
     * <br><strong>Requires: access token</strong>
     * @param subscriptionId id of subscription
     * @param token subscription token
     * @return response object
     * @throws DnevnikApiException if an error occurs
     */
    public BasicResponse validatePayment(@NotNull String subscriptionId, @NotNull String token) throws DnevnikApiException {
        ValidatePaymentRequest validateRequest = ValidatePaymentRequest.builder()
                .subscriptionId(subscriptionId)
                .token(token).build();
        return executeSync(api().validatePayment(getOrUpdateAccessToken(), validateRequest));
    }

    /**
     * <strong>Requires: access token, person id and group id</strong>
     * @return user feed
     * @throws DnevnikApiException if an error occurs
     */
    public FeedResponse getUserFeed() throws DnevnikApiException {
        return executeSync(api().getUserFeed(getOrUpdateAccessToken(), getPersonId(), getGroupId()));
    }

    /**
     * <strong>Requires: access token, person id and group id</strong>
     * @return final marks
     * @throws DnevnikApiException if an error occurs
     */
    public FinalMarksResponse getFinalMarks() throws DnevnikApiException {
        return executeSync(api().getFinalGrades(getOrUpdateAccessToken(), getPersonId(), getGroupId()));
    }

    /**
     * <strong>Requires: access token, person id and group id</strong>
     * @param subjectId subject id
     * @param periodId period id (see {@link UserContext#getPeriods()})
     * @return subject details
     * @throws DnevnikApiException if an error occurs
     */
    public SubjectDetailsResponse getSubjectDetails(long subjectId, long periodId) throws DnevnikApiException {
        return executeSync(api().getSubjectDetails(getOrUpdateAccessToken(), getPersonId(), getGroupId(), subjectId, periodId));
    }

    /**
     * <strong>Requires: access token, person id and group id</strong>
     * @param periodId period id (see {@link UserContext#getPeriods()})
     * @return period marks
     * @throws DnevnikApiException if an error occurs
     */
    public PeriodMarksResponse getPeriodMarks(long periodId) throws DnevnikApiException {
        return executeSync(api().getPeriodMarks(getOrUpdateAccessToken(), getPersonId(), getGroupId(), periodId));
    }

    /**
     * Updates the access token and refresh token. Saves them to a storage for later use in other methods.
     * <br>
     * <strong>Requires: refresh token</strong>
     * <br><br>
     * <strong>Note: old refresh token and access token linked to him can no longer be used.</strong>
     * @return new access token
     * @throws DnevnikApiException if an error occurs
     */
    @Override
    public String refreshAccessToken() throws DnevnikApiException {
        if (!storage.hasRefreshToken()) throw new IllegalStateException("No refresh token present in the storage");
        RefreshTokenRequest refreshTokenRequest = RefreshTokenRequest.builder()
                .refreshToken(storage.getRefreshToken())
                .build();
        RefreshTokenResponse response = executeSync(api().refreshToken(refreshTokenRequest));
        this.storage.setRefreshToken(response.getRefreshToken());
        this.storage.setAccessToken(response.getAccessToken());
        this.storage.setAccessTokenExpireDate(response.getExpiresDate());
        this.storage.getCredentials().setUserId(response.getUser());
        return response.getAccessToken();
    }

    /**
     * Synchronously executes call and returns the result. Used to synchronize api calls.
     * @param call call to execute
     * @return result
     * @param <T> type of result
     * @throws DnevnikApiException if an error occurs
     */
    public <T> T executeSync(@NotNull CompletableFuture<T> call) throws DnevnikApiException {
        try {
            return call.get();
        } catch (RuntimeException | ExecutionException | InterruptedException e) {
            throw new DnevnikApiException(e);
        }
    }

    /**
     * @return person id, throws an exception if not present in storage
     */
    public long getPersonId() {
        if (storage.getPerson() == null) throw new IllegalStateException("person id is required, try to use the updateUserContext()");
        return storage.getPerson().getPersonId();
    }

    /**
     * @return group id, throws an exception if not present in storage
     */
    public long getGroupId() {
        if (storage.getGroup() == null) throw new IllegalStateException("group id is required, try to use the updateUserContext()");
        return storage.getGroup().getId();
    }

    @Override
    public DnevnikApi api() {
        return api;
    }

    public void setApi(DnevnikApi api) {
        this.api = api;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Storage getStorage() {
        return storage;
    }

    @Override
    public String getAccessToken() {
        return storage.getAccessToken();
    }

    public String getOrUpdateAccessToken() {
        OffsetDateTime expireDate = this.getAccessTokenExpireDate();
        if (expireDate != null) {
            if (this.hasRefreshToken() && !OffsetDateTime.now().isBefore(expireDate)) {
                try {
                    this.refreshAccessToken();
                } catch (DnevnikApiException e) {
                }
            }
        }
        // should never be null
        return this.getAccessToken() == null ? "" : this.getAccessToken();
    }

    @Override
    public OffsetDateTime getAccessTokenExpireDate() {
        return storage.getAccessTokenExpireDate();
    }

    @Override
    public boolean hasRefreshToken() {
        return storage.hasRefreshToken();
    }

    @Override
    public boolean isAuthenticated() {
        return storage.isAuthenticated();
    }
}
