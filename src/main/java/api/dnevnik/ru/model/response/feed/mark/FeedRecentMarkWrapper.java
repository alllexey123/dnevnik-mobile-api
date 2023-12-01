package api.dnevnik.ru.model.response.feed.mark;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Value;

@Value
public class FeedRecentMarkWrapper implements Restrictable {

    MarkType type;

    FeedRecentMark content;

    MetaData metadata;

    public enum MarkType {
        SmallMark,
        BigMark
    }
}
