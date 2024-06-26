package api.dnevnik.mobile.model.objects.feed.items;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedItem {

    private FeedItemType type;

    private FeedItemContent content;
}
