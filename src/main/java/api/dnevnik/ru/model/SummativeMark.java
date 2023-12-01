package api.dnevnik.ru.model;

import lombok.Value;

@Value
public class SummativeMark {

    Float quarterMark;

    Float sectionMark;

    String summativeMarkMood;
}
