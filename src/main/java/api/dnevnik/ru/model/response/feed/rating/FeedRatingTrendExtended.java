package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.Trend;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedRatingTrendExtended {

    private String whiteTitle;

    private String description;

    private Trend value;
}
