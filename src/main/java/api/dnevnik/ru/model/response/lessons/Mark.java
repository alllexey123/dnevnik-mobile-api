package api.dnevnik.ru.model.response.lessons;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Value;

@Value
public class Mark implements Restrictable {

    long id;

    String mood;

    String value;

    MetaData metadata;
}
