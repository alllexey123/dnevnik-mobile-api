package api.dnevnik.ru.storage;

import api.dnevnik.ru.model.response.info.Credentials;
import api.dnevnik.ru.model.response.info.Group;
import api.dnevnik.ru.model.response.info.Person;
import api.dnevnik.ru.model.response.info.School;
import api.dnevnik.ru.model.response.info.UserContext;

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
