package api.dnevnik.ru.model.response.feed;

import api.dnevnik.ru.model.response.feed.rating.RatingColor;
import lombok.Value;

@Value
public class FeedGroup {

    String name;

    RatingColor color;

    boolean isContextGroup;
}
