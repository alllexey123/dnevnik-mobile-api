package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FeedTopRankingDynamic implements Restrictable {

    private List<FeedTopMarkChange> values;

    private MetaData metadata;
}
