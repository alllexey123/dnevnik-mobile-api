package api.dnevnik.ru.model.objects.marks.subject;

import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
import lombok.Data;

import java.util.List;

@Data
public class RatingWidget implements Restrictable {

    private MetaData metadata;

    private String groupWidgetTitle;

    private List<RankingPlace> rankingPlaces;

    private String widgetTitle;
}
