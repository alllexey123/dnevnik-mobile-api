package api.dnevnik.ru.model.response;

import api.dnevnik.ru.model.response.info.Region;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class EsiaRegionsResponse extends BasicResponse {
    private List<Region> regions;
}

