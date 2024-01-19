package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.BasicResponse;
import api.dnevnik.ru.model.response.diary.Subject;
import api.dnevnik.ru.model.response.info.Period;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SubjectDetailsResponse extends BasicResponse {

    private Subject subject;

    private Period period;

    private RecentMarks recentMarks;

    private Ranking studentPlace;

    private ReportDetailsResponse reportsPlot;

    private ReportDetailsResponse groupReportsPlot;

    private RatingWidget rating;

}
