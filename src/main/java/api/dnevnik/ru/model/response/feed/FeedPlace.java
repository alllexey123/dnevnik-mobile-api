package api.dnevnik.ru.model.response.feed;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedPlace implements Restrictable {

    private Integer value;

    private MetaData metadata;
}
