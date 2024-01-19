package api.dnevnik.ru.model.response.marks;

import lombok.Data;

@Data
public class WeekAverage {

    private boolean isCurrentWeek;

    private int number;

    private float value;
}
