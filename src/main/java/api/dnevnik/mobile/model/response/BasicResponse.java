package api.dnevnik.mobile.model.response;

import lombok.*;

@Data
public class BasicResponse {

    private ResponseType type;

    private String description;

    private SubscriptionStatus mobileSubscriptionStatus;
}
