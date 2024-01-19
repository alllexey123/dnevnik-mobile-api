package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.Trend;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedRatingMarkChange {

    private Trend trend;

    private String value;
}
