package api.dnevnik.mobile.model.objects.marks.subject;

import api.dnevnik.mobile.model.objects.MetaData;
import api.dnevnik.mobile.model.objects.Restrictable;
import lombok.Data;

@Data
public class Ranking implements Restrictable {

    MetaData metadata;

    int place;
}
