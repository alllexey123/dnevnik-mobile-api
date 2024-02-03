package api.dnevnik.ru.providers;

import api.dnevnik.ru.exceptions.DnevnikApiException;

import java.time.OffsetDateTime;

public interface AccessTokenProvider {

    OffsetDateTime getAccessTokenExpireDate();

    String getAccessToken();

    String refreshAccessToken() throws DnevnikApiException;

    boolean hasRefreshToken();
}
