package api.dnevnik.mobile.model.objects.feed;

import api.dnevnik.mobile.model.response.BasicResponse;
import api.dnevnik.mobile.model.objects.feed.items.FeedItem;
import api.dnevnik.mobile.model.objects.feed.rating.FeedRatingWidget;
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
