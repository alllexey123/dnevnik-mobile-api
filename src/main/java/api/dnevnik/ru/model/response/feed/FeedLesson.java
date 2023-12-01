package api.dnevnik.ru.model.response.feed;

import api.dnevnik.ru.model.response.lessons.Subject;
import lombok.Value;

import java.time.OffsetDateTime;

@Value
public class FeedLesson {

    long id;

    int number;

    String place;

    OffsetDateTime startTime;

    OffsetDateTime endTime;

    Subject subject;

}
