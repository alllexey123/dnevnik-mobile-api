package api.dnevnik.ru.model.response.feed.rating;

import lombok.Value;

@Value
public class FeedTopRankingPlace {

    String imageUrl;

    int place;

    boolean isContextUser;
}
