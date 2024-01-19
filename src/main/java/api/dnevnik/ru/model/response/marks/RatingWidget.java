package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Data;

import java.util.List;

@Data
public class RatingWidget implements Restrictable {

    private MetaData metadata;

    private String groupWidgetTitle;

    private List<RankingPlace> rankingPlaces;

    private String widgetTitle;
}
