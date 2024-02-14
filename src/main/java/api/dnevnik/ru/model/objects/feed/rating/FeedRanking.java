package api.dnevnik.ru.model.objects.feed.rating;

import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedRanking implements Restrictable {

    private Integer place;

    private MetaData metadata;
}
