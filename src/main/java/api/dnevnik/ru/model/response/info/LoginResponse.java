package api.dnevnik.ru.model.response.info;

import api.dnevnik.ru.model.response.BasicResponse;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class LoginResponse extends BasicResponse {

    private Credentials credentials;

    private String reason;

    private String teacherAppLink;

}
