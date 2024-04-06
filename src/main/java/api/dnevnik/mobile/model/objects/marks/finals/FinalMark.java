package api.dnevnik.mobile.model.objects.marks.finals;

import api.dnevnik.mobile.model.objects.lesson.Subject;
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
