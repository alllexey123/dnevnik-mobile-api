package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Data;

@Data
public class Ranking implements Restrictable {

    MetaData metadata;

    int place;
}
