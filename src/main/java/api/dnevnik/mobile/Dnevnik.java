package api.dnevnik.mobile;

import api.dnevnik.mobile.exceptions.DnevnikException;
import api.dnevnik.mobile.model.objects.diary.DiaryDirection;
import api.dnevnik.mobile.model.objects.diary.DiaryResponse;
import api.dnevnik.mobile.model.objects.feed.FeedResponse;
import api.dnevnik.mobile.model.objects.info.Credentials;
import api.dnevnik.mobile.model.objects.info.User;
import api.dnevnik.mobile.model.objects.info.UserContext;
import api.dnevnik.mobile.model.request.*;
import api.dnevnik.mobile.model.response.*;
import api.dnevnik.mobile.storage.Storage;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;
import java.util.List;

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
 *         Using the {@link Dnevnik#create()}. One-liner to create a default instance of the Dnevnik.
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
public class Dnevnik implements IDnevnik {

    public static final String API_URL = "https://api.dnevnik.ru/";

    protected DnevnikApi api;

    protected Storage storage;

    public Dnevnik(DnevnikApi api, Storage storage) {
        this.api = api;
        this.storage = storage;
    }

    /**
     * Creates a new default Dnevnik instance.
     *
     * @return new dnevnik instance
     */
    public static Dnevnik create() {
        return new DnevnikBuilder().build();
    }

    /**
     * Authenticates via student login and password. Saves the received credentials to a storage for later use in other methods.
     *
     * @param username the student username
     * @param password the student password
     * @return login response with credentials
     */
    public Single<LoginResponse> auth(@NotNull String username, @NotNull String password) {
        return Single.just(LoginRequest.builder()
                        .username(username)
                        .password(password).build())
                .flatMap(api::login)
                .doOnSuccess(response -> storage.setCredentials(response.getCredentials()));
    }

    /**
     * Authenticates via student esia task ID and region ID. Saves the received credentials to a storage for later use in other methods.
     * <br><br>
     * <strong>Note: the esia task ID can be obtained after authenticating with the link provided by the {@link Dnevnik#getEsiaRegions()}
     * method. Region IDs are also provided by this method.</strong>
     *
     * @param esiaTaskId esia task id
     * @param regionId   student region id
     * @return login response with credentials
     */
    public Single<EsiaLoginResponse> esiaAuth(@NotNull String esiaTaskId, int regionId) {
        return Single.just(EsiaTaskWrapper.builder()
                        .taskId(esiaTaskId)
                        .regionId(regionId).build())
                .flatMap(wrapper -> api.getEsiaLinkedUsers(wrapper))
                .flatMap(response -> {
                    List<User> users = response.getUsers();
                    if (users.isEmpty())
                        return Single.error(new DnevnikException("No users linked to esia task"));
                    User user = users.get(0);
                    EsiaLoginRequest loginRequest = EsiaLoginRequest.builder()
                            .userId(user.getUserId())
                            .taskId(esiaTaskId)
                            .regionId(regionId).build();
                    return api.esiaLogin(loginRequest);
                })
                .doOnSuccess(response -> {
                    Credentials credentials = response.getAuthorization();
                    storage.setCredentials(credentials);
                });
    }

    /**
     * @return the list of regions to be used for esia authentication
     */
    public Single<EsiaRegionsResponse> getEsiaRegions() {
        return api.getEsiaRegions();
    }

    /**
     * Updates and saves user context using credentials from the storage.
     * <br>User context contains field like school id, person id and group id, which are used in other methods.
     * <br><strong>Requires: access token and user id</strong>
     *
     * @return user context
     */
    public Single<UserContext> updateUserContext() {
        return api.getUserContext(getOrUpdateAccessToken(), storage.getUserId())
                .doOnSuccess(storage::setUserContext);
    }

    /**
     * Validates payment done though Google or Apple service.
     * <br><strong>Requires: access token</strong>
     *
     * @param subscriptionId id of subscription
     * @param token          subscription token
     * @return response object
     */
    public Single<BasicResponse> validatePayment(@NotNull String subscriptionId, @NotNull String token) {
        return Single.just(ValidatePaymentRequest.builder()
                        .subscriptionId(subscriptionId)
                        .token(token).build())
                .flatMap(request -> api.validatePayment(getOrUpdateAccessToken(), request));
    }

    /**
     * <strong>Requires: access token, person id and group id</strong>
     *
     * @return user feed
     */
    public Single<FeedResponse> getUserFeed() {
        return api.getUserFeed(getOrUpdateAccessToken(), getPersonId(), getGroupId());
    }

    /**
     * <strong>Requires: access token, person id and group id</strong>
     *
     * @return final marks
     */
    public Single<FinalMarksResponse> getFinalMarks() {
        return api.getFinalGrades(getOrUpdateAccessToken(), getPersonId(), getGroupId());
    }

    /**
     * <strong>Requires: access token, person id and group id</strong>
     *
     * @param subjectId subject id
     * @param periodId  period id (see {@link UserContext#getPeriods()})
     * @return subject details
     */
    public Single<SubjectDetailsResponse> getSubjectDetails(long subjectId, long periodId) {
        return api.getSubjectDetails(getOrUpdateAccessToken(), getPersonId(), getGroupId(), subjectId, periodId);
    }

    /**
     * <strong>Requires: access token, person id and group id</strong>
     *
     * @param periodId period id (see {@link UserContext#getPeriods()})
     * @return period marks
     */
    public Single<PeriodMarksResponse> getPeriodMarks(long periodId) {
        return api.getPeriodMarks(getOrUpdateAccessToken(), getPersonId(), getGroupId(), periodId);
    }

    /**
     * <strong>Requires: access token, person id, school id and group id</strong><br>
     * If id and direction are null, the current week is returned
     * @param id the date of the first day of the week to receive the next/previous weeks data relative to that week ("yyyy-MM-dd")
     * @param diaryDirection time direction
     * @return diary weeks data
     */
    public Single<DiaryResponse> getDiary(String id, DiaryDirection diaryDirection) {
        return api.getDiary(getOrUpdateAccessToken(), getPersonId(), getSchoolId(), getGroupId(), id, diaryDirection);
    }

    /**
     * <strong>Requires: access token, person id, school id and group id</strong><br>
     * @return relevant diary weeks data
     */
    public Single<DiaryResponse> getRelevantDiary() {
        return getDiary(null, null);
    }
    /**
     * Updates the access token and refresh token. Saves them to a storage for later use in other methods.
     * <br>
     * <strong>Requires: refresh token</strong>
     * <br><br>
     * <strong>Note: old refresh token and access token linked to him can no longer be used.</strong>
     *
     * @return new access token
     */
    public Maybe<String> refreshAccessToken() {
        if (!storage.hasRefreshToken())
            return Maybe.error(new DnevnikException("No refresh token present in the storage"));
        return Single.just(RefreshTokenRequest.builder()
                        .refreshToken(storage.getRefreshToken())
                        .build())
                .flatMap(request -> api.refreshToken(request))
                .doOnSuccess(response -> {
                    this.storage.setRefreshToken(response.getRefreshToken());
                    this.storage.setAccessToken(response.getAccessToken());
                    this.storage.setAccessTokenExpireDate(response.getExpiresDate());
                    this.storage.getCredentials().setUserId(response.getUser());
                })
                .map(RefreshTokenResponse::getAccessToken)
                .toMaybe();
    }

    /**
     * @return person id, throws an exception if not present in storage
     */
    public long getPersonId() {
        if (storage.getPerson() == null)
            throw new IllegalStateException("person id is required, try to use the updateUserContext()");
        return storage.getPerson().getPersonId();
    }

    /**
     * @return group id, throws an exception if not present in storage
     */
    public long getGroupId() {
        if (storage.getGroup() == null)
            throw new IllegalStateException("group id is required, try to use the updateUserContext()");
        return storage.getGroup().getId();
    }

    public long getSchoolId() {
        if (storage.getGroup() == null)
            throw new IllegalStateException("school id is required, try to use the updateUserContext()");
        return storage.getSchool().getId();
    }

    public String getOrUpdateAccessToken() {
        OffsetDateTime expireDate = this.storage.getAccessTokenExpireDate();
        if (expireDate != null) {
            if (this.hasRefreshToken() && !OffsetDateTime.now().isBefore(expireDate)) {
                this.refreshAccessToken().blockingSubscribe();
            }
        }
        // should never be null
        return this.storage.getAccessToken() == null ? "" : this.storage.getAccessToken();
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

    public boolean hasRefreshToken() {
        return storage.hasRefreshToken();
    }

    @Override
    public boolean isAuthenticated() {
        return storage.isAuthenticated();
    }
}
