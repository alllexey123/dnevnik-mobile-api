package api.dnevnik.ru.model.response;

import lombok.*;

@Data
public class BasicResponse {

    private String type;

    private String description;

    private SubscriptionStatus mobileSubscriptionStatus;
}
