package api.dnevnik.ru.model.response.feed.mark;

import api.dnevnik.ru.model.response.lessons.Lesson;
import api.dnevnik.ru.model.response.lessons.Mark;
import api.dnevnik.ru.model.response.lessons.Subject;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.List;

@Value
public class FeedRecentMark {

    List<MarkCategory> categories;

    OffsetDateTime date;

    Subject subject;

    String markType;

    String criteriaMarkType;

    String markTypeText;

    String shortMarkTypeText;

    Lesson lesson;

    boolean isNew;

    boolean isFinal;

    boolean isImportant;

    List<Mark> marks;

    Indicator indicator;

    String elapsedSetMarkTime;
}
