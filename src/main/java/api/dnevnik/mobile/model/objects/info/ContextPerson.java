package api.dnevnik.mobile.model.objects.info;

import lombok.Data;

@Data
public class ContextPerson {

    private String avatarUrl;

    private String firstName;

    private Group group;

    private String lastName;

    private String middleName;

    private long personId;

    private ReportingPeriodGroup reportingPeriodGroup;

    private School school;

    private long schoolId;

    private String sex;

    private long userId;
}
