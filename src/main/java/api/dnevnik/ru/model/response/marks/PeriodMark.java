package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.info.Period;
import lombok.Data;

import java.util.List;

@Data
public class PeriodMark {

    private List<Mark> marks;

    private Period period;
}
