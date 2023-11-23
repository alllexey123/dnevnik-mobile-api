package api.dnevnik.ru;

import api.dnevnik.ru.exceptions.DnevnikApiException;
import api.dnevnik.ru.methods.DnevnikMethods;
import api.dnevnik.ru.methods.impl.DnevnikLogin;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

public class Dnevnik implements IDnevnik {

    private String accessToken;

    private String refreshToken;

    private OkHttpClient defaultClient;

    private Long userId;

    protected DnevnikMethods methods;

    public Dnevnik() {
        defaultClient = new OkHttpClient.Builder()
                .build();
        methods = new DnevnikMethods(this);
    }

    public void auth(@NotNull String username, @NotNull String password) throws DnevnikApiException {
        DnevnikLogin login = methods().login()
                .setUsername(username)
                .setPassword(password);

        DnevnikLogin.ResponseBody response = login.execute().getResponse();
        DnevnikLogin.ResponseBody.Credentials credentials = response.getCredentials();
        setAccessToken(credentials.getAccessToken());
        setRefreshToken(credentials.getRefreshToken());
        setUserId(credentials.getUserId());
    }


    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setDefaultClient(OkHttpClient defaultClient) {
        this.defaultClient = defaultClient;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public String getRefreshToken() {
        return refreshToken;
    }

    @Override
    public OkHttpClient getDefaultClient() {
        return defaultClient;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public DnevnikMethods methods() {
        return methods;
    }

    @Override
    public boolean isAuthenticated() {
        return accessToken != null && userId != null;
    }
}
