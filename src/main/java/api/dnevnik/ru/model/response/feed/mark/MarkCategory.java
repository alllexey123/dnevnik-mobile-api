package api.dnevnik.ru.model.response.feed.mark;

import lombok.Value;

@Value
public class MarkCategory {

    String mood;

    float percent;

    int studentCount;

    int markNumber;

    String value;
}
