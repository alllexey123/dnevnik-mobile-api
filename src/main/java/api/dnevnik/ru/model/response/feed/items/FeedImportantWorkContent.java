package api.dnevnik.ru.model.response.feed.items;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FeedImportantWorkContent implements FeedItemContent {
    private List<ImportantWork> works;
}
