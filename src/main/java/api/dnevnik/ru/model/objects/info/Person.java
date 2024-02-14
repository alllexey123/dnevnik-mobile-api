package api.dnevnik.ru.model.objects.info;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

@Data
public class Person {
    private String sex;

    private long userId;

    private long personId;

    private String firstName;

    private String middleName;

    private String lastName;

    @Nullable
    private String avatarUtl;

    private Group group;

    private School school;

    private ReportingPeriodGroup reportingPeriodGroup;
}
