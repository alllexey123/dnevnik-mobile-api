package api.dnevnik.ru.model.objects.marks.subject;

import lombok.Data;

@Data
public class WeekAverage {

    private boolean isCurrentWeek;

    private int number;

    private float value;
}
