package api.dnevnik.ru.methods;

import okhttp3.Response;

public class DnevnikResponse<MethodResponse> {

    private final Response response;

    private final MethodResponse methodResponse;


    public DnevnikResponse(Response response, MethodResponse methodResponse) {
        this.response = response;
        this.methodResponse = methodResponse;
    }

    public MethodResponse getResponse() {
        return methodResponse;
    }

    public Response getRawResponse() {
        return response;
    }
}
