package api.dnevnik.mobile.model.objects.feed.items;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedBannerContent implements FeedItemContent {

    private String bannerId;

    private Integer maximumViewsCount;

    private String imageUrl;

    private String internalLink;

    private String externalLink;

    private String linkType;

    @Override
    public FeedItemType getItemType() {
        return FeedItemType.BANNER;
    }
}
