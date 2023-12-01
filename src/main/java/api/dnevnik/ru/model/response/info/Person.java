package api.dnevnik.ru.model.response.info;

import lombok.Value;
import org.jetbrains.annotations.Nullable;

@Value
public class Person {
    String sex;

    long userId;

    long personId;

    String firstName;

    String middleName;

    String lastName;

    @Nullable
    String avatarUtl;

    Group group;

    School school;

    ReportingPeriodGroup reportingPeriodGroup;
}
