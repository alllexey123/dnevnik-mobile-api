package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Data;

@Data
public class AverageMarks implements Restrictable {

    private double averageMark;

    private double averageMarkByImportantWork;

    private double weightedAverageMark;

    private String averageMarkByImportantWorkTrend;

    private String averageMarkMood;

    private String averageMarkTrend;

    private Indicator indicator;

    private MetaData metadata;
}
