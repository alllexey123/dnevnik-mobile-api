package api.dnevnik.mobile.model.objects.diary;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Data
public class DayHomeworksProgress {

    private Integer totalLessonsWithHomeworksCount;

    private Integer completedLessonsWithHomeworksCount;

    @Nullable
    private List<Long> lessonWithHomeworksIds;
}
