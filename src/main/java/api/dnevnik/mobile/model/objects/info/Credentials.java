package api.dnevnik.mobile.model.objects.info;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class Credentials {

    private String accessToken;

    private OffsetDateTime expiresDate;

    private String refreshToken;

    private Long userId;

    private String scope;
}
