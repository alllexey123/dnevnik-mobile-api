package api.dnevnik.ru.model.objects.marks.subject;

import api.dnevnik.ru.model.objects.MetaData;
import lombok.Data;

@Data
public class AverageMark {

    private String mark;

    private MetaData metadata;
}
