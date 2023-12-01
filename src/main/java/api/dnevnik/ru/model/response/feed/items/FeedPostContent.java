package api.dnevnik.ru.model.response.feed.items;

import lombok.Value;

import java.time.OffsetDateTime;

@Value
public class FeedPostContent implements FeedItemContent {

    long id;

    String eventKey;

    String topicEventKey;

    String topicLogoUrl;

    String eventUrl;

    String eventSign;

    String title;

    String subtitle;

    String text;

    OffsetDateTime createdDateTime;

    boolean isReaded;

    int commentsCount;

    String authorImageUrl;

    String authorFirstName;

    String authorMiddleName;

    String authorLastName;

    String authorName;

    String previewUrl;

    boolean isNew;
}
