package api.dnevnik.ru.model.objects.marks.finals;

import api.dnevnik.ru.model.objects.marks.Mark;
import lombok.Data;

import java.util.List;

@Data
public class PeriodFinalMarks {

    private List<Mark> marks;

    private String workType;

    private String workTypeName;
}
