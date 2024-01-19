package api.dnevnik.ru.model.response.feed;

import api.dnevnik.ru.model.response.feed.rating.FeedTopRankingDynamic;
import api.dnevnik.ru.model.response.feed.rating.FeedTopRankingPlaces;
import api.dnevnik.ru.model.response.feed.rating.FeedTopRatingTitle;
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
