package api.dnevnik.ru.methods;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import api.dnevnik.ru.IDnevnik;
import api.dnevnik.ru.exceptions.DnevnikApiException;
import okhttp3.*;

import java.io.IOException;

public abstract class DnevnikMethod<MethodResponse> {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String API_VERSION = "v8.5";

    protected final Gson gson = new Gson();

    protected final Request.Builder requestBuilder = new Request.Builder();

    protected final HTTPMethod httpMethod;

    protected final IDnevnik dnevnik;

    protected DnevnikMethod(IDnevnik dnevnik, HTTPMethod httpMethod) {
        this.dnevnik = dnevnik;
        this.httpMethod = httpMethod;
        setAccessToken(dnevnik.getAccessToken() == null ? "" : dnevnik.getAccessToken());
        setHeader("x-platform", "android");
        setHeader("Host", "api.dnevnik.ru");
        setHeader("Connection", "Keep-Alive");
        setHeader("Accept-Encoding", "gzip");
        setHeader("User-Agent", "okhttp/4.9.0");
    }

    public void setPayload(RequestBody requestBody) {
        if (httpMethod != HTTPMethod.POST) throw new IllegalStateException("Invalid usage. Method must be POST");
        requestBuilder.post(requestBody);
    }

    public <T> void setJsonPayload(T json) {
        setPayload(RequestBody.create(gson.toJson(json), JSON));
    }

    public DnevnikResponse<MethodResponse> execute() throws DnevnikApiException {
        requestBuilder.setUrl$okhttp(HttpUrl.parse(getRequestURL()));
        try (Response response = dnevnik.getDefaultClient().newCall(requestBuilder.build()).execute()) {
            return extractResponse(response);
        } catch (IOException e) {
            throw new DnevnikApiException(e);
        }
    }

    protected DnevnikResponse<MethodResponse> extractResponse(Response response) throws DnevnikApiException, IOException {
        if (!response.isSuccessful()) {
            throw new DnevnikApiException("Response code: " + response.code());
        }

        ResponseBody body = response.body();
        if (body == null) {
            throw new DnevnikApiException("Response body is empty");
        }

        String stringBody = body.string();
        try {
            MethodResponse methodResponse = gson.fromJson(stringBody, getResponseType());
            return new DnevnikResponse<>(response, methodResponse);
        } catch (JsonSyntaxException e) {
            throw new DnevnikApiException("Invalid response: " + stringBody);
        }
    }

    public void setAccessToken(String value) {
        setHeader("Access-Token", value);
    }

    protected void setHeader(String name, String value) {
        requestBuilder.header(name, value);
    }

    public abstract TypeToken<MethodResponse> getResponseType();

    public abstract String getRequestURL();

    public String getBaseURL() {
        return String.format("https://api.dnevnik.ru/mobile/%s", getApiVersion());
    }

    public String getApiVersion() {
        return API_VERSION;
    }

    public enum HTTPMethod {
        GET,
        POST;
    }

}
