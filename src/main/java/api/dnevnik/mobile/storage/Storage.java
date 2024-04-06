package api.dnevnik.mobile.storage;

import api.dnevnik.mobile.model.objects.info.*;

import java.time.OffsetDateTime;

public interface Storage {

    UserContext getUserContext();

    Credentials getCredentials();

    String getAccessToken();

    String getRefreshToken();

    OffsetDateTime getAccessTokenExpireDate();

    Long getUserId();

    School getSchool();

    Group getGroup();

    Person getPerson();

    void setUserContext(UserContext userContext);

    void setCredentials(Credentials credentials);

    void setAccessToken(String accessToken);

    void setRefreshToken(String refreshToken);

    void setAccessTokenExpireDate(OffsetDateTime accessTokenExpireDate);

    boolean isAuthenticated();

    boolean hasRefreshToken();
}
