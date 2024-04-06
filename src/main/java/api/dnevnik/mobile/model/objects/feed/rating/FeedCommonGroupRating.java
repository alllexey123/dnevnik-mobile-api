package api.dnevnik.mobile.model.objects.feed.rating;

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
