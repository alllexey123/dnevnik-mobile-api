package api.dnevnik.ru.model.objects.marks;

import api.dnevnik.ru.model.objects.lesson.Lesson;
import api.dnevnik.ru.model.objects.lesson.Subject;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.StringJoiner;

@Data
public class RecentMark {

    private List<MarkCategory> categories;

    private OffsetDateTime date;

    private Subject subject;

    private String markType;

    private String criteriaMarkType;

    private String markTypeText;

    private String shortMarkTypeText;

    private Lesson lesson;

    private boolean isNew;

    private boolean isFinal;

    private boolean isImportant;

    private List<Mark> marks;

    private Indicator indicator;

    private String elapsedSetMarkTime;

    public String marksToString() {
        StringJoiner sj = new StringJoiner("/");
        marks.stream().map(Mark::toString).forEach(sj::add);
        return sj.toString();
    }
}
