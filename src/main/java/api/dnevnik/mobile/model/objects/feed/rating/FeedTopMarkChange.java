package api.dnevnik.mobile.model.objects.feed.rating;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedTopMarkChange {

    private FeedRatingMarkChange averageMarkChange;

    private String imageUrl;

    private Boolean isContextUser;
}
