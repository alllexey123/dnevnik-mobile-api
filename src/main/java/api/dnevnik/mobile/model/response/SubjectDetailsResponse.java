package api.dnevnik.mobile.model.response;

import api.dnevnik.mobile.model.objects.info.Period;
import api.dnevnik.mobile.model.objects.lesson.Subject;
import api.dnevnik.mobile.model.objects.marks.subject.Ranking;
import api.dnevnik.mobile.model.objects.marks.subject.RatingWidget;
import api.dnevnik.mobile.model.objects.marks.subject.RecentMarks;
import api.dnevnik.mobile.model.objects.marks.subject.ReportDetailsResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.Nullable;

@EqualsAndHashCode(callSuper = true)
@Data
public class SubjectDetailsResponse extends BasicResponse {

    private Subject subject;

    private Period period;

    private RecentMarks recentMarks;

    // can be null if the student has no marks
    @Nullable
    private Ranking studentPlace;

    private ReportDetailsResponse reportsPlot;

    private ReportDetailsResponse groupReportsPlot;

    private RatingWidget rating;

}
