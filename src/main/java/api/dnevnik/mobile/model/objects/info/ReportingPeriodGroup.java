package api.dnevnik.mobile.model.objects.info;

import lombok.Data;

import java.util.List;

@Data
public class ReportingPeriodGroup {

    private String id;

    private String type;

    private List<Period> periods;
}
