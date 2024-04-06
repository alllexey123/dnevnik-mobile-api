package api.dnevnik.mobile.model.objects.marks.period;

import api.dnevnik.mobile.model.objects.marks.SummativeMark;
import api.dnevnik.mobile.model.objects.marks.RecentMark;
import api.dnevnik.mobile.model.objects.lesson.Subject;
import api.dnevnik.mobile.model.objects.marks.AverageMarks;
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
