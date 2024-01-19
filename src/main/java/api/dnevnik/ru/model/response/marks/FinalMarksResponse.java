package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.BasicResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class FinalMarksResponse extends BasicResponse {

    private List<FinalMark> finalMarks;
}
