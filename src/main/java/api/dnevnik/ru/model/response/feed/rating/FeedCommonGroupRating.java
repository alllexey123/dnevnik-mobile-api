package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.RatingTrend;
import lombok.Value;

import java.util.List;

@Value
public class FeedCommonGroupRating  {

    RatingTrend trend;

    FeedRanking groupRanking;

    List<FeedRankingPlace> rankingPlaces;
}
