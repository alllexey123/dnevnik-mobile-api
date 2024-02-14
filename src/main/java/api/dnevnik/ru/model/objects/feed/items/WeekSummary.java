package api.dnevnik.ru.model.objects.feed.items;

import api.dnevnik.ru.model.objects.marks.AverageMarks;
import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
import api.dnevnik.ru.model.objects.lesson.Subject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class WeekSummary implements Restrictable {

    private LocalDate localDate;

    private Subject subject;

    private List<SubjectMark> subjectMarks;

    private AverageMarks averageMarks;

    private MetaData metadata;
}
