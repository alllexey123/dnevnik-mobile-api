package api.dnevnik.mobile.model.objects.marks.subject;

import api.dnevnik.mobile.model.objects.marks.Trend;
import lombok.Data;

@Data
public class AverageMarkChange {

    private Trend trend;

    private String value;
}
