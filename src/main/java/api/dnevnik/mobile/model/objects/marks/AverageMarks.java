package api.dnevnik.mobile.model.objects.marks;

import api.dnevnik.mobile.model.objects.MetaData;
import api.dnevnik.mobile.model.objects.Restrictable;
import lombok.Data;

@Data
public class AverageMarks implements Restrictable {

    private double averageMark;

    private double averageMarkByImportantWork;

    private double weightedAverageMark;

    private Trend averageMarkByImportantWorkTrend;

    private Mood averageMarkMood;

    private Trend averageMarkTrend;

    private Indicator indicator;

    private MetaData metadata;
}
