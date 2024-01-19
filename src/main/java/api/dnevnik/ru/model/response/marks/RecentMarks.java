package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Data;

import java.util.List;

@Data
public class RecentMarks implements Restrictable {

    private List<RecentMark> marks;

    private MetaData metadata;

}
