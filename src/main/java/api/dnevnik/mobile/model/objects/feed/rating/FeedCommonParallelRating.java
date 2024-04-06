package api.dnevnik.mobile.model.objects.feed.rating;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedCommonParallelRating {

    private RatingTrend trend;

    private FeedRanking parallelRanking;
}
