package api.dnevnik.ru.model.response.marks;

import api.dnevnik.ru.model.response.feed.rating.RatingColor;
import lombok.Data;

@Data
public class RatingLine {

    private RatingColor color;

    private String groupName;

    private String imageUrl;

    private int scalePercent;

}
