package api.dnevnik.ru.model.response.marks;


import api.dnevnik.ru.model.SummativeMark;
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
