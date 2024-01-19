package api.dnevnik.ru.model.response.feed.items;

import api.dnevnik.ru.model.response.marks.AverageMarks;
import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import api.dnevnik.ru.model.response.diary.Subject;
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
