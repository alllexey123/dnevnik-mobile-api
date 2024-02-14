package api.dnevnik.ru.model.response;

import api.dnevnik.ru.model.objects.info.Credentials;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class LoginResponse extends BasicResponse {

    private Credentials credentials;

    private String reason;

    private String teacherAppLink;

}
