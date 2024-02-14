package api.dnevnik.ru.model.objects.feed;

import api.dnevnik.ru.model.response.BasicResponse;
import api.dnevnik.ru.model.objects.feed.items.FeedItem;
import api.dnevnik.ru.model.objects.feed.rating.FeedRatingWidget;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class FeedResponse extends BasicResponse {

    private List<FeedItem> feed;

    private FeedHomeworksProgress homeworksProgress;

    private FeedRatingWidget ratingFeedWidget;

    private List<FeedRecentMarkWrapper> recentMarks;

    private FeedSchedule schedule;
}
