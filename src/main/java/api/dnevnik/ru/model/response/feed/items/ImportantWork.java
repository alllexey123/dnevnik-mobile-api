package api.dnevnik.ru.model.response.feed.items;

import api.dnevnik.ru.model.SummativeMark;
import api.dnevnik.ru.model.response.AverageMarks;
import api.dnevnik.ru.model.response.lessons.Subject;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ImportantWork {

    LocalDate date;

    String workTypeName;

    Subject subject;

    long lessonId;

    int lessonNumber;

    AverageMarks averageMarks;

    SummativeMark summativeMarks;
}
