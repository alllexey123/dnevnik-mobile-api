package api.dnevnik.ru.model.response.feed;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import api.dnevnik.ru.model.response.marks.RecentMark;
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
