package api.dnevnik.mobile.model.response;

import api.dnevnik.mobile.model.objects.info.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class EsiaLinkedUsersResponse extends BasicResponse {

    private List<User> users;
}
