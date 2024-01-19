package api.dnevnik.ru;

import api.dnevnik.ru.networking.AccessTokenInterceptor;
import api.dnevnik.ru.providers.DefaultDnevnikApiSupplier;
import api.dnevnik.ru.providers.DefaultGsonSupplier;
import api.dnevnik.ru.providers.DefaultOkHttpClientSupplier;
import api.dnevnik.ru.providers.DefaultRetrofitSupplier;
import api.dnevnik.ru.storage.DefaultStorage;
import api.dnevnik.ru.storage.Storage;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.util.function.Supplier;

public final class DnevnikBuilder {

    private Supplier<Gson> gsonSupplier = null;

    private Supplier<OkHttpClient> okHttpClientSupplier = null;

    private Supplier<Retrofit> retrofitSupplier = null;

    private Supplier<DnevnikApi> apiSupplier = null;

    private Supplier<Storage> storageSupplier = null;

    public DnevnikBuilder() {
    }

    public DnevnikBuilder setGson(Supplier<Gson> gsonSupplier) {
        this.gsonSupplier = gsonSupplier;
        return this;
    }

    public DnevnikBuilder setOkHttpClient(Supplier<OkHttpClient> okHttpClientSupplier) {
        this.okHttpClientSupplier = okHttpClientSupplier;
        return this;
    }

    public DnevnikBuilder setRetrofit(Supplier<Retrofit> retrofitSupplier) {
        this.retrofitSupplier = retrofitSupplier;
        return this;
    }

    public DnevnikBuilder setApi(Supplier<DnevnikApi> apiSupplier) {
        this.apiSupplier = apiSupplier;
        return this;
    }

    public DnevnikBuilder setStorage(Supplier<Storage> storageSupplier) {
        this.storageSupplier = storageSupplier;
        return this;
    }

    public Dnevnik build() {
        AccessTokenInterceptor interceptor = null;

        DnevnikApi api;
        if (apiSupplier != null) {
            api = apiSupplier.get();
        } else {
            Retrofit retrofit;
            if (retrofitSupplier != null) {
                retrofit = retrofitSupplier.get();
            } else {
                if (gsonSupplier == null) gsonSupplier = new DefaultGsonSupplier();
                Gson gson = gsonSupplier.get();
                if (okHttpClientSupplier == null) okHttpClientSupplier = new DefaultOkHttpClientSupplier(
                        interceptor = new AccessTokenInterceptor(() -> null));
                OkHttpClient okHttpClient = okHttpClientSupplier.get();
                retrofit = new DefaultRetrofitSupplier(gson, okHttpClient).get();
            }

            api = new DefaultDnevnikApiSupplier(retrofit).get();
        }
        Storage storage;
        if (storageSupplier != null) storage = storageSupplier.get();
        else storage = new DefaultStorage();

        Dnevnik result = new Dnevnik(api, storage);
        if (interceptor != null) interceptor.setDnevnikSupplier(() -> result);
        return result;
    }

}
