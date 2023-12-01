package api.dnevnik.ru.model.response.feed;

import api.dnevnik.ru.model.SubscriptionStatus;
import api.dnevnik.ru.model.response.BasicResponse;
import api.dnevnik.ru.model.response.feed.items.FeedItem;
import api.dnevnik.ru.model.response.feed.mark.FeedRecentMarkWrapper;
import api.dnevnik.ru.model.response.feed.rating.FeedRatingWidget;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
public class FeedResponse extends BasicResponse {
    public FeedResponse(String type, String description, SubscriptionStatus mobileSubscriptionStatus, List<FeedItem> feed, FeedHomeworksProgress homeworksProgress, FeedRatingWidget ratingFeedWidget, List<FeedRecentMarkWrapper> recentMarks, FeedSchedule schedule) {
        super(type, description, mobileSubscriptionStatus);
        this.feed = feed;
        this.homeworksProgress = homeworksProgress;
        this.ratingFeedWidget = ratingFeedWidget;
        this.recentMarks = recentMarks;
        this.schedule = schedule;
    }

    List<FeedItem> feed;

    FeedHomeworksProgress homeworksProgress;

    FeedRatingWidget ratingFeedWidget;

    List<FeedRecentMarkWrapper> recentMarks;

    FeedSchedule schedule;
}
