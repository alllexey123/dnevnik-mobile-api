package api.dnevnik.mobile.model.objects.feed.rating;

import api.dnevnik.mobile.model.objects.marks.Trend;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedRatingTrendExtended {

    private String whiteTitle;

    private String description;

    private Trend value;
}
