package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.BasicResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PeriodMarksResponse extends BasicResponse {

    private List<SubjectMarks> periodMarks;

    private long periodNumber;


}
