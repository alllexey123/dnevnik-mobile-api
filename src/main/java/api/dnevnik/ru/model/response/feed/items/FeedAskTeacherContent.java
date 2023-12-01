package api.dnevnik.ru.model.response.feed.items;

import api.dnevnik.ru.model.response.lessons.Mark;
import lombok.Value;

@Value
public class FeedAskTeacherContent implements FeedItemContent {

    Mark mark;

    String text;

    long lessonId;

    String buttonText;
}
