package api.dnevnik.mobile.model.objects.feed.items;

import api.dnevnik.mobile.model.objects.marks.AverageMarks;
import api.dnevnik.mobile.model.objects.MetaData;
import api.dnevnik.mobile.model.objects.Restrictable;
import api.dnevnik.mobile.model.objects.lesson.Subject;
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
