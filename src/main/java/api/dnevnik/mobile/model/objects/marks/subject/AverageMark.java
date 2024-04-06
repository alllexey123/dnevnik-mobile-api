package api.dnevnik.mobile.model.objects.marks.subject;

import api.dnevnik.mobile.model.objects.MetaData;
import lombok.Data;

@Data
public class AverageMark {

    private String mark;

    private MetaData metadata;
}
