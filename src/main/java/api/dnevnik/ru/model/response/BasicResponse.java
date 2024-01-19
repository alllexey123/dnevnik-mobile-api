package api.dnevnik.ru.model.response;

import api.dnevnik.ru.model.SubscriptionStatus;
import lombok.*;

@Data
public class BasicResponse {

    private String type;

    private String description;

    private SubscriptionStatus mobileSubscriptionStatus;
}
