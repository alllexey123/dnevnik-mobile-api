package api.dnevnik.ru.model.response;

import api.dnevnik.ru.model.objects.marks.period.SubjectMarks;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PeriodMarksResponse extends BasicResponse {

    private List<SubjectMarks> periodMarks;

    private long periodNumber;


}
