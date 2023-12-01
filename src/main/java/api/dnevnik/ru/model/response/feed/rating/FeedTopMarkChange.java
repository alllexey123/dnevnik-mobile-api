package api.dnevnik.ru.model.response.feed.rating;

import lombok.Value;

@Value
public class FeedTopMarkChange {

    FeedRatingMarkChange averageMarkChange;

    String imageUrl;

    boolean isContextUser;
}
