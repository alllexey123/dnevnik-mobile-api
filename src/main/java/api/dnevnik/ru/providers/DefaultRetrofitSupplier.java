package api.dnevnik.ru.providers;

import api.dnevnik.ru.Dnevnik;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.function.Supplier;

public class DefaultRetrofitSupplier implements Supplier<Retrofit> {

    private final Gson gson;

    private final OkHttpClient okHttpClient;

    public DefaultRetrofitSupplier(Gson gson, OkHttpClient okHttpClient) {
        this.gson = gson;
        this.okHttpClient = okHttpClient;
    }

    @Override
    public Retrofit get() {
        return new Retrofit.Builder()
                .baseUrl(Dnevnik.API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
