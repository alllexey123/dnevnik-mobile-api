package api.dnevnik.ru.model.response.info;

import lombok.Data;

import java.util.List;

@Data
public class ReportingPeriodGroup {

    private String id;

    private String type;

    private List<Period> periods;
}
