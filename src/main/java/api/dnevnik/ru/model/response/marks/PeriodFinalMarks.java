package api.dnevnik.ru.model.response.marks;

import lombok.Data;

import java.util.List;

@Data
public class PeriodFinalMarks {

    private List<Mark> marks;

    private String workType;

    private String workTypeName;
}
