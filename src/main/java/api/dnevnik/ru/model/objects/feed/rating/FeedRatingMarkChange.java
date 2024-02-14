package api.dnevnik.ru.model.objects.feed.rating;

import api.dnevnik.ru.model.objects.marks.Trend;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedRatingMarkChange {

    private Trend trend;

    private String value;
}
