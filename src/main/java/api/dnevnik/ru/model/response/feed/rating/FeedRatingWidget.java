package api.dnevnik.ru.model.response.feed.rating;

import api.dnevnik.ru.model.response.feed.FeedTopRating;
import lombok.Value;

import java.util.List;

@Value
public class FeedRatingWidget {

    FeedCommonGroupRating commonGroupRatingEvent;

    FeedCommonParallelRating commonParallelRatingEvent;

    FeedTopRating topRatingEvent;

    List<FeedGroupRatingBySubject> groupRatingBySubjectEvents;

    List<FeedPersonalRatingBySubject> personalRatingBySubjectEvents;
}
