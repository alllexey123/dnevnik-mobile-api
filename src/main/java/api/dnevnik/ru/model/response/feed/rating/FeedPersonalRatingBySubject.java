package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.feed.FeedPlace;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedPersonalRatingBySubject {

    private FeedRatingTrendExtended trend;

    private FeedRatingSubject subject;

    private FeedPlace place;
}
