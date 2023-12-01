package api.dnevnik.ru.model.response.info;

import api.dnevnik.ru.model.SubscriptionStatus;
import api.dnevnik.ru.model.response.BasicResponse;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
public class UserContext extends BasicResponse {

    public UserContext(String type, String description, SubscriptionStatus mobileSubscriptionStatus, Info info, List<Person> contextPersons) {
        super(type, description, mobileSubscriptionStatus);
        this.info = info;
        this.contextPersons = contextPersons;
    }

    Info info;

    List<Person> contextPersons;
    public Person getPerson() {
        return contextPersons.get(0);
    }

    @Value
    public static class Info {

        String sex;

        long userId;

        long personId;

        String firstName;

        String middleName;

        String lastName;

        @Nullable
        String avatarUtl;

        String currentCultureCode;
    }

}
