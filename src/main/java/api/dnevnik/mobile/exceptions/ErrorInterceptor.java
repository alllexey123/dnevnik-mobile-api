package api.dnevnik.mobile.exceptions;

import api.dnevnik.mobile.model.response.BasicResponse;
import api.dnevnik.mobile.model.response.ResponseType;
import api.dnevnik.mobile.providers.DefaultGsonSupplier;
import com.google.gson.Gson;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class ErrorInterceptor implements Interceptor {

    private final Gson gson = new DefaultGsonSupplier().get();

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        try {
            Response response = chain.proceed(chain.request());
            ResponseBody body = response.body();
            String bodyString = body == null ? null : body.string();
            if (!response.isSuccessful()) {
                int responseCode = response.code();
                String message = response.message();
                response.close();
                switch (responseCode) {
                    case 401:
                        throw new DnevnikException("Not Authorized");
                    case 503:
                        throw new DnevnikException("Service Unavailable");
                    case 550:
                        throw new DnevnikException("Server Work");
                    default:
                        throw new DnevnikException(message);
                }
            } else {
                if (bodyString != null) {
                    BasicResponse parsedResponse = gson.fromJson(bodyString, BasicResponse.class);
                    if (parsedResponse.getType() != null && parsedResponse.getType() != ResponseType.SUCCESS) {
                        throw new DnevnikException(parsedResponse.getDescription());
                    }
                }
                if (bodyString == null) bodyString = "";
                MediaType mediaType = null;
                if (body != null) mediaType = body.contentType();
                return response.newBuilder().body(ResponseBody.create(mediaType, bodyString)).build();
            }
        } catch (DnevnikException e) {
            throw e;
        } catch (Exception e) {
            if (e instanceof ConnectException || e instanceof UnknownHostException || e instanceof SocketTimeoutException) {
                throw new DnevnikException("Ошибка сети. Проверьте подключение к интернету.");
            }
            throw new DnevnikException(e.getLocalizedMessage());
        }
    }
}
