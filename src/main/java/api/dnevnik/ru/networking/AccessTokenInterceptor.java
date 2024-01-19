package api.dnevnik.ru.networking;

import api.dnevnik.ru.Dnevnik;
import lombok.Setter;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.function.Supplier;

public class AccessTokenInterceptor implements Interceptor {

    @Setter
    private Supplier<Dnevnik> dnevnikSupplier;

    public AccessTokenInterceptor(Supplier<Dnevnik> dnevnikSupplier) {
        this.dnevnikSupplier = dnevnikSupplier;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Dnevnik dnevnik;
        if (dnevnikSupplier == null || (dnevnik = dnevnikSupplier.get()) == null) return chain.proceed(chain.request());
        OffsetDateTime expireDate = dnevnik.getStorage().getAccessTokenExpireDate();
        Request request = chain.request();
        if (!request.url().pathSegments().contains("bycredentials") & expireDate != null) {
            if (dnevnik.getStorage().getRefreshToken().length() > 1 && !OffsetDateTime.now().isBefore(expireDate)) {
                dnevnik.refreshAccessToken();
            }
        }
        return chain.proceed(request.newBuilder().header("Access-Token", dnevnik.getAccessToken()).build());
    }

}
