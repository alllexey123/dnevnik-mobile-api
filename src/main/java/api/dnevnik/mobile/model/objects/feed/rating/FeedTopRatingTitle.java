package api.dnevnik.mobile.model.objects.feed.rating;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedTopRatingTitle {

    private String value;

    private RatingTrend trend;
}
