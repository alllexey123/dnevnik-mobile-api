package api.dnevnik.mobile.model.response;

import api.dnevnik.mobile.model.objects.marks.finals.FinalMark;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class FinalMarksResponse extends BasicResponse {

    private List<FinalMark> finalMarks;
}
