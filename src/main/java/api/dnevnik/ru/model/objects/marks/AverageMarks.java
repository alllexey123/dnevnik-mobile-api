package api.dnevnik.ru.model.objects.marks;

import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
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
