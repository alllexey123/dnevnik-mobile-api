package api.dnevnik.mobile.model.objects.diary;

import lombok.Data;

@Data
public class Teacher {

    // can be zero!
    private long personId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String avatarUrl;
}
