package api.dnevnik.ru.model.response.feed.items;

import lombok.Value;

@Value
public class FeedBannerContent implements FeedItemContent {

    String bannerId;

    int maximumViewsCount;

    String imageUrl;

    String internalLink;

    String externalLink;

    String linkType;
}
