package api.dnevnik.mobile.model.objects.diary;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class DiaryDay {

    private OffsetDateTime dateTime;

    private boolean hasImportantWork;

    private DayHomeworksProgress dayHomeworksProgress;

    private List<DiaryLesson> lessons;
}
