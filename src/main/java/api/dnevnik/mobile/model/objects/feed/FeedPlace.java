package api.dnevnik.mobile.model.objects.feed;

import api.dnevnik.mobile.model.objects.MetaData;
import api.dnevnik.mobile.model.objects.Restrictable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedPlace implements Restrictable {

    private Integer value;

    private MetaData metadata;
}
