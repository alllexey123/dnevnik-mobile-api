package api.dnevnik.ru.model.objects.feed.rating;

import api.dnevnik.ru.model.objects.feed.FeedGroup;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedGroupRatingBySubject {

    private FeedRatingTrendExtended trend;

    private FeedRatingSubject subject;

    private FeedGroup group;
}
