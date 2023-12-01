package api.dnevnik.ru.model.response.feed.items;

import lombok.Value;

@Value
public class FeedItem {

    FeedItemType type;

    FeedItemContent content;
}
