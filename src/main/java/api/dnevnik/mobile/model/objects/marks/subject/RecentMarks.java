package api.dnevnik.mobile.model.objects.marks.subject;

import api.dnevnik.mobile.model.objects.MetaData;
import api.dnevnik.mobile.model.objects.Restrictable;
import api.dnevnik.mobile.model.objects.marks.RecentMark;
import lombok.Data;

import java.util.List;

@Data
public class RecentMarks implements Restrictable {

    private List<RecentMark> marks;

    private MetaData metadata;

}
