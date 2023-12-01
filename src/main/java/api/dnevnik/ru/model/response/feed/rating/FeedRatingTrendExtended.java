package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.Trend;
import lombok.Value;

@Value
public class FeedRatingTrendExtended {

    String whiteTitle;

    String description;

    Trend value;
}
