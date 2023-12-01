package api.dnevnik.ru.storage;

import api.dnevnik.ru.model.response.info.Credentials;
import api.dnevnik.ru.model.response.info.Group;
import api.dnevnik.ru.model.response.info.Person;
import api.dnevnik.ru.model.response.info.School;
import api.dnevnik.ru.model.response.info.UserContext;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DefaultStorage implements Storage {

    private UserContext userContext;

    private Credentials credentials;

    @Override
    public UserContext getUserContext() {
        return userContext;
    }

    @Override
    public Credentials getCredentials() {
        return credentials;
    }

    @Override
    public String getAccessToken() {
        return credentials == null ? "" : credentials.getAccessToken();
    }

    @Override
    public String getRefreshToken() {
        return credentials == null ? "" : credentials.getRefreshToken();
    }

    @Override
    public LocalDateTime getAccessTokenExpireDate() {
        return credentials == null ? LocalDateTime.MIN : credentials.getExpiresDate();
    }

    @Override
    public Long getUserId() {
        return credentials == null
                ? userContext == null ? null : userContext.getInfo().getUserId()
                : credentials.getUserId();
    }

    @Override
    public School getSchool() {
        return userContext == null ? null : userContext.getPerson().getSchool();
    }

    @Override
    public Group getGroup() {
        return userContext == null ? null : userContext.getPerson().getGroup();
    }

    @Override
    public Person getPerson() {
        return userContext == null ? null : userContext.getPerson();
    }

    @Override
    public void setUserContext(UserContext userContext) {
        this.userContext = userContext;
    }

    @Override
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public boolean isAuthenticated() {
        return getAccessToken() != null && getAccessTokenExpireDate().isAfter(LocalDateTime.now(ZoneOffset.UTC));
    }

    @Override
    public boolean hasRefreshToken() {
        return getRefreshToken() != null;
    }
}
