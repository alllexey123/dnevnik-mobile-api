package api.dnevnik.mobile.model.objects.feed.rating;

import api.dnevnik.mobile.model.objects.feed.FeedPlace;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedPersonalRatingBySubject {

    private FeedRatingTrendExtended trend;

    private FeedRatingSubject subject;

    private FeedPlace place;
}
