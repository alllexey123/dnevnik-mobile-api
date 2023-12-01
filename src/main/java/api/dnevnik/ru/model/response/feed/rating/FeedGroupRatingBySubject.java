package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.feed.FeedGroup;
import lombok.Value;

@Value
public class FeedGroupRatingBySubject {

    FeedRatingTrendExtended trend;

    FeedRatingSubject subject;

    FeedGroup group;
}
