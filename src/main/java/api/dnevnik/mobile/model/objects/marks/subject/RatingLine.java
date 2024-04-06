package api.dnevnik.mobile.model.objects.marks.subject;

import api.dnevnik.mobile.model.objects.feed.rating.RatingColor;
import lombok.Data;

@Data
public class RatingLine {

    private RatingColor color;

    private String groupName;

    private String imageUrl;

    private int scalePercent;

}
