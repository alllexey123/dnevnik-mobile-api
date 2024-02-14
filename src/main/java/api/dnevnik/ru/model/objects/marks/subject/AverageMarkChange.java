package api.dnevnik.ru.model.objects.marks.subject;

import api.dnevnik.ru.model.objects.marks.Trend;
import lombok.Data;

@Data
public class AverageMarkChange {

    private Trend trend;

    private String value;
}
