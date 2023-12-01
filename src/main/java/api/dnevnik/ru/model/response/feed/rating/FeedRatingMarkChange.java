package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.Trend;
import lombok.Value;

@Value
public class FeedRatingMarkChange {

    Trend trend;

    String value;
}
