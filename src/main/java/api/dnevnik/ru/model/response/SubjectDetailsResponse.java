package api.dnevnik.ru.model.response;

import api.dnevnik.ru.model.objects.info.Period;
import api.dnevnik.ru.model.objects.lesson.Subject;
import api.dnevnik.ru.model.objects.marks.subject.Ranking;
import api.dnevnik.ru.model.objects.marks.subject.RatingWidget;
import api.dnevnik.ru.model.objects.marks.subject.RecentMarks;
import api.dnevnik.ru.model.objects.marks.subject.ReportDetailsResponse;
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
