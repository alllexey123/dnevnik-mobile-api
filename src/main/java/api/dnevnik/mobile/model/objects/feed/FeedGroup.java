package api.dnevnik.mobile.model.objects.feed;

import api.dnevnik.mobile.model.objects.feed.rating.RatingColor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedGroup {

    private String name;

    private RatingColor color;

    private Boolean isContextGroup;
}
