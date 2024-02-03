package api.dnevnik.ru.model.response.info;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ExtendedCredentials {

    @SerializedName("user_str")
    private String userString;

    private String accessToken;

    private String refreshToken;

    private Long user;

    private String scope;

    /**
     * Access token lifetime in seconds
     */
    private Long expiresIn;

    @SerializedName("expiresIn_str")
    private String expiresInString;

    public OffsetDateTime getExpireDate() {
        return OffsetDateTime.now().plusSeconds(expiresIn);
    }
}
