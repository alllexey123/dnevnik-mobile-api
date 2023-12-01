package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.feed.FeedPlace;
import lombok.Value;

@Value
public class FeedPersonalRatingBySubject {

    FeedRatingTrendExtended trend;

    FeedRatingSubject subject;

    FeedPlace place;
}
