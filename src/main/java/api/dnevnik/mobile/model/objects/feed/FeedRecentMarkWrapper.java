package api.dnevnik.mobile.model.objects.feed;

import api.dnevnik.mobile.model.objects.MetaData;
import api.dnevnik.mobile.model.objects.Restrictable;
import api.dnevnik.mobile.model.objects.marks.RecentMark;
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
