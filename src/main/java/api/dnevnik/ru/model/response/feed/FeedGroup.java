package api.dnevnik.ru.model.response.feed;

import api.dnevnik.ru.model.response.feed.rating.RatingColor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedGroup {

    private String name;

    private RatingColor color;

    private Boolean isContextGroup;
}
