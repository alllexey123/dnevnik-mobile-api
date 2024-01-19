package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.info.ContextPerson;
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
