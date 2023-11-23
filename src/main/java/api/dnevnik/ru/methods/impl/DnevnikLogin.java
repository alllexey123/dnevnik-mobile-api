package api.dnevnik.ru.methods.impl;

import com.google.gson.reflect.TypeToken;
import api.dnevnik.ru.IDnevnik;
import api.dnevnik.ru.exceptions.DnevnikApiException;
import api.dnevnik.ru.methods.DnevnikMethod;
import api.dnevnik.ru.methods.DnevnikResponse;
import api.dnevnik.ru.objects.MobileSubscriptionStatus;

public class DnevnikLogin extends DnevnikMethod<DnevnikLogin.ResponseBody> {

    private String username;

    private String password;

    public DnevnikLogin(IDnevnik dnevnik) {
        super(dnevnik, HTTPMethod.POST);
    }

    @Override
    public TypeToken<ResponseBody> getResponseType() {
        return TypeToken.get(ResponseBody.class);
    }

    @Override
    public DnevnikResponse<ResponseBody> execute() throws DnevnikApiException {
        if (username == null) {
            throw new IllegalStateException("Username is required to login");
        }
        if (password == null) {
            throw new IllegalStateException("Password is required to login");
        }
        RequestData requestData = new RequestData();
        requestData.setUsername(username);
        requestData.setPassword(password);
        setJsonPayload(requestData);
        return super.execute();
    }

    public DnevnikLogin setUsername(String username) {
        this.username = username;
        return this;
    }

    public DnevnikLogin setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String getRequestURL() {
        return getBaseURL() + "/authorizations/bycredentials";
    }

    public static class ResponseBody {

        private Credentials credentials;

        private MobileSubscriptionStatus mobileSubscriptionStatus;

        public Credentials getCredentials() {
            return credentials;
        }

        public MobileSubscriptionStatus getMobileSubscriptionStatus() {
            return mobileSubscriptionStatus;
        }

        @Override
        public String toString() {
            return "ResponseBody{" +
                    "credentials=" + credentials +
                    ", mobileSubscriptionStatus=" + mobileSubscriptionStatus +
                    '}';
        }

        public static class Credentials {
            private String accessToken;
            private String refreshToken;
            private long userId;
            private String expiresDate;

            public String getAccessToken() {
                return accessToken;
            }

            public String getRefreshToken() {
                return refreshToken;
            }

            public long getUserId() {
                return userId;
            }

            public String getExpiresDate() {
                return expiresDate;
            }

            @Override
            public String toString() {
                return "Credentials{" +
                        "accessToken='" + accessToken + '\'' +
                        ", refreshToken='" + refreshToken + '\'' +
                        ", userId=" + userId +
                        ", expiresDate='" + expiresDate + '\'' +
                        '}';
            }
        }
    }

    public static class RequestData {
        private String clientId = "1d7bd105-4cd1-4f6c-9ecc-394e400b53bd";

        private String clientSecret = "5dcb5237-b5d3-406b-8fee-4441c3a66c99";

        private String username;

        private String password;

        private String scope = "Schools,Relatives,EduGroups,Lessons,marks,EduWorks,Avatar";

        private boolean agreeTerms = false;


        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
