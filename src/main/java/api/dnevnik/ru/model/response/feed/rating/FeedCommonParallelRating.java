package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.RatingTrend;
import lombok.Value;

@Value
public class FeedCommonParallelRating {

    RatingTrend trend;

    FeedRanking parallelRanking;
}
