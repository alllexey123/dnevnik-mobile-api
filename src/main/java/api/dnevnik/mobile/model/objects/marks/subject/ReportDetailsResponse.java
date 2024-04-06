package api.dnevnik.mobile.model.objects.marks.subject;


import api.dnevnik.mobile.model.objects.marks.SummativeMark;
import api.dnevnik.mobile.model.objects.marks.AverageMarks;
import lombok.Data;

import java.util.List;

@Data
public class ReportDetailsResponse {

    private AverageMarks averageMarks;

    private String knowledgeAreaGroup;

    private String knowledgeAreaName;

    private List<ReportingPeriodsReport> reportingPeriodsReports;

    private SummativeMark summativeMark;
}
