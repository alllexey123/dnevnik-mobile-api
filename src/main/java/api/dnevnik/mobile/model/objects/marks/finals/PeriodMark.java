package api.dnevnik.mobile.model.objects.marks.finals;

import api.dnevnik.mobile.model.objects.info.Period;
import api.dnevnik.mobile.model.objects.marks.Mark;
import lombok.Data;

import java.util.List;

@Data
public class PeriodMark {

    private List<Mark> marks;

    private Period period;
}
