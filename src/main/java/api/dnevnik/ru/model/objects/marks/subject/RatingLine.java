package api.dnevnik.ru.model.objects.marks.subject;

import api.dnevnik.ru.model.objects.feed.rating.RatingColor;
import lombok.Data;

@Data
public class RatingLine {

    private RatingColor color;

    private String groupName;

    private String imageUrl;

    private int scalePercent;

}
