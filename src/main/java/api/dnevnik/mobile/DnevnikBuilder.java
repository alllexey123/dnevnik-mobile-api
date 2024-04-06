package api.dnevnik.mobile;

import api.dnevnik.mobile.providers.DefaultDnevnikApiSupplier;
import api.dnevnik.mobile.providers.DefaultGsonSupplier;
import api.dnevnik.mobile.providers.DefaultOkHttpClientSupplier;
import api.dnevnik.mobile.providers.DefaultRetrofitSupplier;
import api.dnevnik.mobile.storage.DefaultStorage;
import api.dnevnik.mobile.storage.Storage;
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
                if (okHttpClientSupplier == null) okHttpClientSupplier = new DefaultOkHttpClientSupplier();
                OkHttpClient okHttpClient = okHttpClientSupplier.get();
                retrofit = new DefaultRetrofitSupplier(gson, okHttpClient).get();
            }

            api = new DefaultDnevnikApiSupplier(retrofit).get();
        }
        Storage storage;
        if (storageSupplier != null) storage = storageSupplier.get();
        else storage = new DefaultStorage();
        return new Dnevnik(api, storage);
    }

}
