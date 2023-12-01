package api.dnevnik.ru.model.response.info;

import api.dnevnik.ru.model.SubscriptionStatus;
import api.dnevnik.ru.model.response.BasicResponse;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Value
public class LoginResponse extends BasicResponse {

    public LoginResponse(String type, String description, SubscriptionStatus mobileSubscriptionStatus, Credentials credentials, String reason, String teacherAppLink) {
        super(type, description, mobileSubscriptionStatus);
        this.credentials = credentials;
        this.reason = reason;
        this.teacherAppLink = teacherAppLink;
    }

    Credentials credentials;

    String reason;

    String teacherAppLink;

}
