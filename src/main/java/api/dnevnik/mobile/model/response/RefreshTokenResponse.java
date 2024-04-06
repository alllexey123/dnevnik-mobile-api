package api.dnevnik.mobile.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class RefreshTokenResponse extends BasicResponse {

    private String accessToken;

    private String refreshToken;

    private Long user;

    private String scope;

    private OffsetDateTime expiresDate;
}
