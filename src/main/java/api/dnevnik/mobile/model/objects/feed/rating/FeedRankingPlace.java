package api.dnevnik.mobile.model.objects.feed.rating;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedRankingPlace {

    private Integer scalePercent;

    private String imageUrl;

    private Boolean isContextUser;
}
