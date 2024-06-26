package api.dnevnik.mobile.model.objects.feed;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class FeedSchedule {

    private LocalDate nextLessonDate;

    private List<FeedLesson> todayLessons;

    private List<FeedLesson> tomorrowLessons;
}
