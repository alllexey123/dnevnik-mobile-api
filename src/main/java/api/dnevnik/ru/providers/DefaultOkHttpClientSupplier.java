package api.dnevnik.ru.providers;

import api.dnevnik.ru.networking.AccessTokenInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import java.util.function.Supplier;

public class DefaultOkHttpClientSupplier implements Supplier<OkHttpClient> {

    private final AccessTokenInterceptor accessTokenInterceptor;

    public DefaultOkHttpClientSupplier(AccessTokenInterceptor accessTokenInterceptor) {
        this.accessTokenInterceptor = accessTokenInterceptor;
    }


    @Override
    public OkHttpClient get() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(System.out::println);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(accessTokenInterceptor)
                .build();
    }
}
