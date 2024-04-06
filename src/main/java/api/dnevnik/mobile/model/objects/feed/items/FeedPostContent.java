package api.dnevnik.mobile.model.objects.feed.items;

import api.dnevnik.mobile.model.objects.lesson.Attachment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

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

    private List<Attachment> files;

    private List<Attachment> attachmentFiles;

    @Override
    public FeedItemType getItemType() {
        return FeedItemType.POST;
    }
}
