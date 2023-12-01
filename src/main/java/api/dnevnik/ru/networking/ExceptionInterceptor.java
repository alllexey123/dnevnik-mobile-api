package api.dnevnik.ru.networking;

import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ExceptionInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        //todo
        throw new IllegalStateException("Not implemented yet");
    }
}
