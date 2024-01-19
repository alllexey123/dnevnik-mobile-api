package api.dnevnik.ru.model.response.feed.rating;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RatingColor {

    private String border;

    private String gradientStart;

    private String gradientEnd;
}
