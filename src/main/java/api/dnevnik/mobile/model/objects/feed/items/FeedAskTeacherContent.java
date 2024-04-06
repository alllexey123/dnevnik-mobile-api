package api.dnevnik.mobile.model.objects.feed.items;

import api.dnevnik.mobile.model.objects.marks.Mark;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedAskTeacherContent implements FeedItemContent {

    private Mark mark;

    private String text;

    private Long lessonId;

    private String buttonText;

    @Override
    public FeedItemType getItemType() {
        return FeedItemType.ASK_TEACHER;
    }
}
