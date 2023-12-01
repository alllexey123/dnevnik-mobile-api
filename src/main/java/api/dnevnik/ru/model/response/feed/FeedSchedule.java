package api.dnevnik.ru.model.response.feed;

import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class FeedSchedule {

    LocalDate nextLessonDate;

    List<FeedLesson> todayLessons;

    List<FeedLesson> tomorrowLessons;
}
