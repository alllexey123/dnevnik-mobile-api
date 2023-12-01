package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Value;

import java.util.List;

@Value
public class FeedTopRankingDynamic implements Restrictable {

    List<FeedTopMarkChange> values;

    MetaData metadata;
}
