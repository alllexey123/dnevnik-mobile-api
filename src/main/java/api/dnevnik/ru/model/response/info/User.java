package api.dnevnik.ru.model.response.info;

import lombok.Data;

@Data
public class User {

    private String avatarUrl;

    private String firstName;

    private String lastName;

    private String middleName;

    private School school;

    private Long userId;
}
