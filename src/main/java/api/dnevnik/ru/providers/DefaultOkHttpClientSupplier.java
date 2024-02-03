package api.dnevnik.ru.providers;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import java.util.function.Supplier;

public class DefaultOkHttpClientSupplier implements Supplier<OkHttpClient> {

    public DefaultOkHttpClientSupplier() {
    }

    @Override
    public OkHttpClient get() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(System.out::println);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }
}
