package api.dnevnik.ru.model.objects.feed;

import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedPlace implements Restrictable {

    private Integer value;

    private MetaData metadata;
}
