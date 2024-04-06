package api.dnevnik.mobile.model.objects.feed;

import api.dnevnik.mobile.model.objects.feed.rating.FeedTopRankingDynamic;
import api.dnevnik.mobile.model.objects.feed.rating.FeedTopRankingPlaces;
import api.dnevnik.mobile.model.objects.feed.rating.FeedTopRatingTitle;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedTopRating {

    private FeedTopRatingTitle title;

    private FeedTopRankingPlaces topRankingPlace;

    private FeedTopRankingDynamic topRankingDynamic;

    private Long subjectId;
}
