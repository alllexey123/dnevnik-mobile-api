package api.dnevnik.mobile.model.objects.feed.rating;

import api.dnevnik.mobile.model.objects.MetaData;
import api.dnevnik.mobile.model.objects.Restrictable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedRanking implements Restrictable {

    private Integer place;

    private MetaData metadata;
}
