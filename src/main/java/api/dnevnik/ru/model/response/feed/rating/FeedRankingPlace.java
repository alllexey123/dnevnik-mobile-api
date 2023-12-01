package api.dnevnik.ru.model.response.feed.rating;

import lombok.Value;

@Value
public class FeedRankingPlace {

    int scalePercent;

    String imageUrl;

    boolean isContextUser;
}
