package api.dnevnik.ru.model.objects.feed.rating;

import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FeedTopRankingDynamic implements Restrictable {

    private List<FeedTopMarkChange> values;

    private MetaData metadata;
}
