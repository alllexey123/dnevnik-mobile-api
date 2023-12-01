package api.dnevnik.ru.model.response;

import api.dnevnik.ru.model.response.feed.mark.Indicator;
import lombok.Value;

@Value
public class AverageMarks implements Restrictable {

    double averageMark;

    double averageMarkByImportantWork;

    double weightedAverageMark;

    String averageMarkByImportantWorkTrend;

    String averageMarkMood;

    String averageMarkTrend;

    Indicator indicator;

    MetaData metadata;
}
