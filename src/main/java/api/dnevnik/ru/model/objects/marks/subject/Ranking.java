package api.dnevnik.ru.model.objects.marks.subject;

import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
import lombok.Data;

@Data
public class Ranking implements Restrictable {

    MetaData metadata;

    int place;
}
