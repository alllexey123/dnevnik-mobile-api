package api.dnevnik.ru.storage;

import api.dnevnik.ru.model.response.info.*;

import java.time.OffsetDateTime;

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
    public OffsetDateTime getAccessTokenExpireDate() {
        return credentials == null ? OffsetDateTime.MIN : credentials.getExpiresDate();
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
    public void setExtendedCredentials(ExtendedCredentials extendedCredentials) {
        if (this.credentials == null) {
            this.credentials = new Credentials();
        }
        this.credentials.setUserId(extendedCredentials.getUser());
        this.credentials.setAccessToken(extendedCredentials.getAccessToken());
        this.credentials.setScope(extendedCredentials.getScope());
        this.credentials.setExpiresDate(extendedCredentials.getExpireDate());
        this.credentials.setRefreshToken(extendedCredentials.getRefreshToken());
    }

    @Override
    public void setAccessToken(String accessToken) {
        if (this.credentials == null) {
            this.credentials = new Credentials();
        }
        this.credentials.setAccessToken(accessToken);
    }

    @Override
    public void setRefreshToken(String refreshToken) {
        if (this.credentials == null) {
            this.credentials = new Credentials();
        }
        this.credentials.setRefreshToken(refreshToken);
    }

    @Override
    public void setAccessTokenExpireDate(OffsetDateTime accessTokenExpireDate) {
        if (this.credentials == null) {
            this.credentials = new Credentials();
        }
        this.credentials.setExpiresDate(accessTokenExpireDate);
    }

    @Override
    public boolean isAuthenticated() {
        return getAccessToken() != null && getAccessTokenExpireDate().isBefore(OffsetDateTime.now());
    }

    @Override
    public boolean hasRefreshToken() {
        return getRefreshToken() != null;
    }
}
