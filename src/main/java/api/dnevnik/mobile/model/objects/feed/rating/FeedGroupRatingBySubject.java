package api.dnevnik.mobile.model.objects.feed.rating;

import api.dnevnik.mobile.model.objects.feed.FeedGroup;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedGroupRatingBySubject {

    private FeedRatingTrendExtended trend;

    private FeedRatingSubject subject;

    private FeedGroup group;
}
