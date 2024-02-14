package api.dnevnik.ru.model.objects.feed;

import api.dnevnik.ru.model.objects.lesson.Subject;
import api.dnevnik.ru.model.objects.lesson.Hours;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class FeedLesson {

    private Long id;

    private Integer number;

    private String place;

    private OffsetDateTime startTime;

    private OffsetDateTime endTime;

    private Subject subject;

    private Hours hours;

}
