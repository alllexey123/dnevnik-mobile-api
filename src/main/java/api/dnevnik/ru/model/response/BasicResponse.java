package api.dnevnik.ru.model.response;

import api.dnevnik.ru.model.SubscriptionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BasicResponse {

    private final String type;

    private final String description;

    private final SubscriptionStatus mobileSubscriptionStatus;
}
