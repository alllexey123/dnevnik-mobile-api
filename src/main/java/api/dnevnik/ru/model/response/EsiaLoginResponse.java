package api.dnevnik.ru.model.response;

import api.dnevnik.ru.model.objects.info.Credentials;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EsiaLoginResponse extends BasicResponse {

    private Credentials authorization;

    private EsiaStatus status;

    @Data
    public static class EsiaStatus {
        private final String code;

        private final String description;
    }
}
