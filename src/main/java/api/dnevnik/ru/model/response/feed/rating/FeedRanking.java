package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Value;
@Value
public class FeedRanking implements Restrictable {

    int place;

    MetaData metadata;
}
