package api.dnevnik.mobile.model.request;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class RefreshTokenRequest {

    @SerializedName("client_id")
    @Builder.Default
    String clientId = "1d7bd105-4cd1-4f6c-9ecc-394e400b53bd";

    @SerializedName("client_secret")
    @Builder.Default
    String clientSecret = "5dcb5237-b5d3-406b-8fee-4441c3a66c99";

    @SerializedName("grant_type")
    @Builder.Default
    String grantType = "RefreshToken";

    String refreshToken;
}
