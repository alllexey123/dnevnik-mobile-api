package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.marks.RatingTrend;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FeedCommonGroupRating  {

    private RatingTrend trend;

    private FeedRanking groupRanking;

    private List<FeedRankingPlace> rankingPlaces;
}
