package api.dnevnik.ru.model.objects.feed.items;

import api.dnevnik.ru.model.objects.marks.Mark;
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
