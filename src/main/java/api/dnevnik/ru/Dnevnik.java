package api.dnevnik.ru;

import api.dnevnik.ru.exceptions.DnevnikApiException;
import api.dnevnik.ru.model.request.ValidatePaymentRequest;
import api.dnevnik.ru.model.response.BasicResponse;
import api.dnevnik.ru.model.response.feed.FeedResponse;
import api.dnevnik.ru.model.response.feed.items.FeedItem;
import api.dnevnik.ru.model.response.info.UserContext;
import api.dnevnik.ru.networking.AccessTokenInterceptor;
import api.dnevnik.ru.model.request.LoginRequest;
import api.dnevnik.ru.model.response.info.LoginResponse;
import api.dnevnik.ru.storage.DefaultStorage;
import api.dnevnik.ru.storage.Storage;
import api.dnevnik.ru.utils.FeedItemDeserializer;
import api.dnevnik.ru.utils.LocalDateDeserializer;
import api.dnevnik.ru.utils.LocalDateTimeDeserializer;
import api.dnevnik.ru.utils.OffsetDateTimeDeserializer;
import com.google.gson.*;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Dnevnik implements IDnevnik {

    private static final String API_URL = "https://api.dnevnik.ru/";

    protected Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
            .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeDeserializer())
            .registerTypeAdapter(FeedItem.class, new FeedItemDeserializer())
            .create();

    protected OkHttpClient defaultClient;

    protected DnevnikApi api;

    protected Storage storage;

    public Dnevnik() {
        this.storage = new DefaultStorage();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(System.out::println);

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        defaultClient = new OkHttpClient.Builder()
                //.addInterceptor(logging)
                .addInterceptor(new AccessTokenInterceptor(this))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(defaultClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api = retrofit.create(DnevnikApi.class);
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
        return executeSync(api.getUserFeed(storage.getGroup().getId(), storage.getPerson().getPersonId()));
    }


    public <T> T executeSync(@NotNull CompletableFuture<T> call) throws DnevnikApiException {
        try {
            return call.get();
        } catch (RuntimeException | ExecutionException | InterruptedException e) {
            throw new DnevnikApiException(e);
        }
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
    public OkHttpClient getDefaultClient() {
        return defaultClient;
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
