package api.dnevnik.ru.model.response.info;

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
