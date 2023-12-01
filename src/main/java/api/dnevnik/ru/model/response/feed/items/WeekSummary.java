package api.dnevnik.ru.model.response.feed.items;

import api.dnevnik.ru.model.response.AverageMarks;
import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import api.dnevnik.ru.model.response.lessons.Subject;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class WeekSummary implements Restrictable {

    LocalDate localDate;

    Subject subject;

    List<SubjectMark> subjectMarks;

    AverageMarks averageMarks;

    MetaData metadata;
}
