package api.dnevnik.ru.model.response.feed.rating;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedTopRankingPlace {

    private String imageUrl;

    private Integer place;

    private Boolean isContextUser;
}
