package api.dnevnik.ru.model.response.feed.items;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedItem {

    private FeedItemType type;

    private FeedItemContent content;
}
