package api.dnevnik.ru.model.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EsiaTaskWrapper {

    int regionId;

    String taskId;
}
