package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.Trend;
import lombok.Data;

@Data
public class AverageMarkChange {

    private Trend trend;

    private String value;
}
