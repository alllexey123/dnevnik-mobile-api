package api.dnevnik.ru.model.objects.feed.items;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class FeedPostContent implements FeedItemContent {

    private Long id;

    private String eventKey;

    private String topicEventKey;

    private String topicLogoUrl;

    private String eventUrl;

    private String eventSign;

    private String title;

    private String subtitle;

    private String text;

    private OffsetDateTime createdDateTime;

    boolean isReaded;

    private Integer commentsCount;

    private String authorImageUrl;

    private String authorFirstName;

    private String authorMiddleName;

    private String authorLastName;

    private String authorName;

    private String previewUrl;

    private Boolean isNew;
}
