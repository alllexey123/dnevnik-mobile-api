package api.dnevnik.ru.model.response.marks;

import lombok.Data;

@Data
public class MarkCategory {

    private String mood;

    private float percent;

    private int studentCount;

    private int markNumber;

    private String value;
}
