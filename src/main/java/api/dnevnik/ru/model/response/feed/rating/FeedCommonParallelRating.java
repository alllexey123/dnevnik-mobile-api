package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.marks.RatingTrend;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedCommonParallelRating {

    private RatingTrend trend;

    private FeedRanking parallelRanking;
}
