package api.dnevnik.ru.networking;

import api.dnevnik.ru.Dnevnik;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class AccessTokenInterceptor implements Interceptor {

    private final Dnevnik dnevnik;

    public AccessTokenInterceptor(Dnevnik dnevnik) {
        this.dnevnik = dnevnik;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        LocalDateTime expireDate = dnevnik.getStorage().getAccessTokenExpireDate();
        Request request = chain.request();
        if (!request.url().pathSegments().contains("bycredentials") & expireDate != null) {
            if (dnevnik.getStorage().getRefreshToken().length() > 1 && !LocalDateTime.now(ZoneOffset.UTC).isBefore(expireDate)) {
                dnevnik.refreshAccessToken();
            }
        }
        return chain.proceed(request.newBuilder().header("Access-Token", dnevnik.getAccessToken()).build());
    }
}
