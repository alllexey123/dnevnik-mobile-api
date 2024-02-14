package api.dnevnik.ru.model.objects.marks.period;

import api.dnevnik.ru.model.objects.marks.SummativeMark;
import api.dnevnik.ru.model.objects.marks.RecentMark;
import api.dnevnik.ru.model.objects.lesson.Subject;
import api.dnevnik.ru.model.objects.marks.AverageMarks;
import lombok.Data;

import java.util.List;

@Data
public class SubjectMarks {

    private AverageMarks averageMarks;

    private SubjectFinalMark finalMark;

    private Subject subject;

    private List<RecentMark> recentMarks;

    private SummativeMark summativeMark;

}
