package api.dnevnik.mobile.model.objects.feed.items;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FeedImportantWorkContent implements FeedItemContent {
    private List<ImportantWork> works;

    @Override
    public FeedItemType getItemType() {
        return FeedItemType.IMPORTANT_WORK;
    }
}
