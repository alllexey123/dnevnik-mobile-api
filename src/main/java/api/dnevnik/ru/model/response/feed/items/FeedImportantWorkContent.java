package api.dnevnik.ru.model.response.feed.items;

import lombok.Value;

import java.util.List;

@Value
public class FeedImportantWorkContent implements FeedItemContent {
    List<ImportantWork> works;
}
