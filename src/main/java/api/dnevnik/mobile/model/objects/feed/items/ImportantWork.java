package api.dnevnik.mobile.model.objects.feed.items;

import api.dnevnik.mobile.model.objects.marks.SummativeMark;
import api.dnevnik.mobile.model.objects.marks.AverageMarks;
import api.dnevnik.mobile.model.objects.lesson.Subject;
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
