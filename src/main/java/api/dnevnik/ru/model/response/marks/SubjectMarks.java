package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.SummativeMark;
import api.dnevnik.ru.model.response.diary.Subject;
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
