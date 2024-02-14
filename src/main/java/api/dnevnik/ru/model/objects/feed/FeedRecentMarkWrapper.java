package api.dnevnik.ru.model.objects.feed;

import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
import api.dnevnik.ru.model.objects.marks.RecentMark;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedRecentMarkWrapper implements Restrictable {

    private MarkType type;

    private RecentMark content;

    private MetaData metadata;

    public enum MarkType {
        SmallMark,
        BigMark
    }
}
