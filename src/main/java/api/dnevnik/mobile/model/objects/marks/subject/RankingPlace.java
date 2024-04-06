package api.dnevnik.mobile.model.objects.marks.subject;

import api.dnevnik.mobile.model.objects.info.ContextPerson;
import lombok.Data;

@Data
public class RankingPlace {

    private AverageMark averageMark;

    private AverageMarkChange averageMarkChange;

    private Ranking contextGroupRanking;

    private ContextPerson contextPerson;

    private boolean isContextUser;

    private Ranking ranking;

    private RatingLine ratingLine;
}
