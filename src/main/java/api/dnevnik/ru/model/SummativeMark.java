package api.dnevnik.ru.model;

import lombok.Data;

@Data
public class SummativeMark {

    private Float quarterMark;

    private Float sectionMark;

    private String summativeMarkMood;
}
