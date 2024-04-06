package api.dnevnik.mobile.model.objects.marks.subject;

import lombok.Data;

@Data
public class WeekAverage {

    private boolean isCurrentWeek;

    private int number;

    private float value;
}
