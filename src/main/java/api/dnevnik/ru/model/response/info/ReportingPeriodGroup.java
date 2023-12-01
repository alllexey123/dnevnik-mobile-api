package api.dnevnik.ru.model.response.info;

import lombok.Value;

import java.util.List;

@Value
public class ReportingPeriodGroup {

    String id;

    String type;

    List<Period> periods;
}
