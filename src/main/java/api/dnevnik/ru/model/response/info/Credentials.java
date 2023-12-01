package api.dnevnik.ru.model.response.info;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Credentials {

    private final String accessToken;

    private final LocalDateTime expiresDate;

    private final String refreshToken;

    private final Long userId;

    private final String scope;
}
