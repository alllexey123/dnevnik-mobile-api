package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.feed.FeedGroup;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedGroupRatingBySubject {

    private FeedRatingTrendExtended trend;

    private FeedRatingSubject subject;

    private FeedGroup group;
}
