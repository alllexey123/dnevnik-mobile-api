package api.dnevnik.mobile.providers;

import api.dnevnik.mobile.DnevnikApi;
import retrofit2.Retrofit;

import java.util.function.Supplier;

public class DefaultDnevnikApiSupplier implements Supplier<DnevnikApi> {

    private final Retrofit retrofit;

    public DefaultDnevnikApiSupplier(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public DnevnikApi get() {
        return retrofit.create(DnevnikApi.class);
    }
}
