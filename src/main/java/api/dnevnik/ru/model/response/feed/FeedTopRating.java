package api.dnevnik.ru.model.response.feed;

import api.dnevnik.ru.model.response.feed.rating.FeedTopRankingDynamic;
import api.dnevnik.ru.model.response.feed.rating.FeedTopRankingPlaces;
import api.dnevnik.ru.model.response.feed.rating.FeedTopRatingTitle;
import lombok.Value;

@Value
public class FeedTopRating {

    FeedTopRatingTitle title;

    FeedTopRankingPlaces topRankingPlace;

    FeedTopRankingDynamic topRankingDynamic;

    long subjectId;
}
