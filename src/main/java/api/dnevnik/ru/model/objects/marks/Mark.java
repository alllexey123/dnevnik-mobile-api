package api.dnevnik.ru.model.objects.marks;

import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
import lombok.Data;

@Data
public class Mark implements Restrictable {

    private long id;

    private String mood;

    private String value;

    private MetaData metadata;
}
