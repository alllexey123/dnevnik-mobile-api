package api.dnevnik.ru.model.response.feed;

import api.dnevnik.ru.model.response.diary.Subject;
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

}
