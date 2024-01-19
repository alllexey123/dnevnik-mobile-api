package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.MetaData;
import lombok.Data;

@Data
public class AverageMark {

    private String mark;

    private MetaData metadata;
}
