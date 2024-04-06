package api.dnevnik.mobile.model.response;

import api.dnevnik.mobile.model.objects.info.Region;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class EsiaRegionsResponse extends BasicResponse {
    private List<Region> regions;
}

