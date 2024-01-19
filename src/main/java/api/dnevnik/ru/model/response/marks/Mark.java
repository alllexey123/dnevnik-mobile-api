package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Data;

@Data
public class Mark implements Restrictable {

    private long id;

    private String mood;

    private String value;

    private MetaData metadata;
}
