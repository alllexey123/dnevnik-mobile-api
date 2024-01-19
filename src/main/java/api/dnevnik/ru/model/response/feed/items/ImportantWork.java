package api.dnevnik.ru.model.response.feed.items;

import api.dnevnik.ru.model.SummativeMark;
import api.dnevnik.ru.model.response.marks.AverageMarks;
import api.dnevnik.ru.model.response.diary.Subject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ImportantWork {

    private LocalDate date;

    private String workTypeName;

    private Subject subject;

    private Long lessonId;

    private Integer lessonNumber;

    private AverageMarks averageMarks;

    private SummativeMark summativeMarks;
}
