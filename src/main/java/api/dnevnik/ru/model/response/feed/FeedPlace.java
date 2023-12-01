package api.dnevnik.ru.model.response.feed;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Value;

@Value
public class FeedPlace implements Restrictable {

    int value;

    MetaData metadata;
}
