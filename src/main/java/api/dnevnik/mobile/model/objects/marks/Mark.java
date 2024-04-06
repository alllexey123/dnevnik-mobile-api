package api.dnevnik.mobile.model.objects.marks;

import api.dnevnik.mobile.model.objects.MetaData;
import api.dnevnik.mobile.model.objects.Restrictable;
import lombok.Data;

@Data
public class Mark implements Restrictable {

    private long id;

    private Mood mood;

    private String value;

    private MetaData metadata;
}
