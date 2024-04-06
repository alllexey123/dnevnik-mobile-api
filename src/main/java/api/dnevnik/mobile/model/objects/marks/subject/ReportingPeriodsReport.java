package api.dnevnik.mobile.model.objects.marks.subject;

import lombok.Data;

import java.util.List;

@Data
public class ReportingPeriodsReport {
    private boolean isCurrent;

    private long periodId;

    private long periodNumber;

    private PeriodType periodType;

    private List<WeekAverage> weekAverages;
}
