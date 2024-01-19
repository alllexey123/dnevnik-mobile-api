package api.dnevnik.ru;

import api.dnevnik.ru.exceptions.DnevnikApiException;
import api.dnevnik.ru.model.request.ValidatePaymentRequest;
import api.dnevnik.ru.model.response.BasicResponse;
import api.dnevnik.ru.model.response.feed.FeedResponse;
import api.dnevnik.ru.model.response.info.UserContext;
import api.dnevnik.ru.model.response.marks.FinalMarksResponse;
import api.dnevnik.ru.model.response.marks.PeriodMarksResponse;
import api.dnevnik.ru.model.response.marks.SubjectDetailsResponse;
import api.dnevnik.ru.model.request.LoginRequest;
import api.dnevnik.ru.model.response.info.LoginResponse;
import api.dnevnik.ru.storage.Storage;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Dnevnik implements IDnevnik {

    public static final String API_URL = "https://api.dnevnik.ru/";

    protected DnevnikApi api;

    protected Storage storage;

    public Dnevnik(DnevnikApi api, Storage storage) {
        this.api = api;
        this.storage = storage;
    }

    public static Dnevnik newInstance() {
        return new DnevnikBuilder().build();
    }

    public LoginResponse auth(@NotNull String username, @NotNull String password) throws DnevnikApiException {
        LoginRequest request = LoginRequest.builder()
                .username(username)
                .password(password).build();
        LoginResponse response = executeSync(api.login(request));
        storage.setCredentials(response.getCredentials());
        return response;
    }

    public UserContext updateUserContext() throws DnevnikApiException {
        UserContext userContext = executeSync(api.getUserContext(storage.getUserId()));
        storage.setUserContext(userContext);
        return userContext;
    }

    public BasicResponse validatePayment(@NotNull String subscriptionId, @NotNull String token) throws DnevnikApiException {
        ValidatePaymentRequest validateRequest = ValidatePaymentRequest.builder()
                .subscriptionId(subscriptionId)
                .token(token).build();
        return executeSync(api.validatePayment(validateRequest));
    }

    public FeedResponse getUserFeed() throws DnevnikApiException {
        return executeSync(api.getUserFeed(getGroupId(), getPersonId()));
    }

    public FinalMarksResponse getFinalMarks() throws DnevnikApiException {
        return executeSync(api.getFinalGrades(getPersonId(), getGroupId()));
    }


    public SubjectDetailsResponse getSubjectDetails(long subjectId, long periodId) throws DnevnikApiException {
        return executeSync(api.getSubjectDetails(getPersonId(), getGroupId(), subjectId, periodId));
    }

    public PeriodMarksResponse getPeriodMarks(long periodId) throws DnevnikApiException {
        return executeSync(api.getPeriodMarks(getPersonId(), getGroupId(), periodId));
    }


    public <T> T executeSync(@NotNull CompletableFuture<T> call) throws DnevnikApiException {
        try {
            return call.get();
        } catch (RuntimeException | ExecutionException | InterruptedException e) {
            throw new DnevnikApiException(e);
        }
    }

    public long getPersonId() {
        if (storage.getPerson() == null) throw new IllegalStateException("person id is required, try to use the updateUserContext()");
        return storage.getPerson().getPersonId();
    }

    public long getGroupId() {
        if (storage.getGroup() == null) throw new IllegalStateException("group id is required, try to use the updateUserContext()");
        return storage.getGroup().getId();
    }

    @Override
    public DnevnikApi api() {
        return api;
    }

    @Override
    public Storage getStorage() {
        return storage;
    }

    @Override
    public String getAccessToken() {
        return storage.getAccessToken();
    }

    @Override
    public boolean isAuthenticated() {
        return storage.isAuthenticated();
    }

    @Override
    public String refreshAccessToken() {
        throw new RuntimeException("Not implemented yet");
    }
}
