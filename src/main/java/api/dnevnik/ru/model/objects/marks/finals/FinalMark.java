package api.dnevnik.ru.model.objects.marks.finals;

import api.dnevnik.ru.model.objects.lesson.Subject;
import lombok.Data;

import java.util.List;

@Data
public class FinalMark {

    private long itemId;

    private String knowledgeArea;

    private Subject subject;

    private List<PeriodFinalMarks> periodFinalMarks;

    private List<PeriodMark> periodMarks;
}
