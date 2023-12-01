package api.dnevnik.ru.model.response.feed;

import lombok.Value;

import java.util.List;

@Value
public class FeedHomeworksProgress {

    int totalLessonsWithHomeworksCount;

    int completedLessonsWithHomeworksCount;

    List<Long> lessonsWithHomeworksIds;
}
