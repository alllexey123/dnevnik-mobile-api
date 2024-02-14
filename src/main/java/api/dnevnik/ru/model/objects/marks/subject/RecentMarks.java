package api.dnevnik.ru.model.objects.marks.subject;

import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
import api.dnevnik.ru.model.objects.marks.RecentMark;
import lombok.Data;

import java.util.List;

@Data
public class RecentMarks implements Restrictable {

    private List<RecentMark> marks;

    private MetaData metadata;

}
