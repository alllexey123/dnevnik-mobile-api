package api.dnevnik.mobile.providers;

import api.dnevnik.mobile.exceptions.ErrorInterceptor;
import okhttp3.OkHttpClient;

import java.util.function.Supplier;

public class DefaultOkHttpClientSupplier implements Supplier<OkHttpClient> {

    public DefaultOkHttpClientSupplier() {
    }

    @Override
    public OkHttpClient get() {
        return new OkHttpClient.Builder()
                .addInterceptor(new ErrorInterceptor())
                .build();
    }
}
