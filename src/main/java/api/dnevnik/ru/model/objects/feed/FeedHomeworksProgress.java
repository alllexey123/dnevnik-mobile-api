package api.dnevnik.ru.model.objects.feed;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FeedHomeworksProgress {

    private Integer totalLessonsWithHomeworksCount;

    private Integer completedLessonsWithHomeworksCount;

    private List<Long> lessonsWithHomeworksIds;
}
