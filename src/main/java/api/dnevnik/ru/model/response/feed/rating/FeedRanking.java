package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedRanking implements Restrictable {

    private Integer place;

    private MetaData metadata;
}
