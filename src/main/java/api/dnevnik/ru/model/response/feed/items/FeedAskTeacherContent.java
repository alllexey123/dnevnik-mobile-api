package api.dnevnik.ru.model.response.feed.items;

import api.dnevnik.ru.model.response.marks.Mark;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedAskTeacherContent implements FeedItemContent {

    private Mark mark;

    private String text;

    private Long lessonId;

    private String buttonText;
}
