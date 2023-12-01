package api.dnevnik.ru.model.response.info;

import lombok.Value;

@Value
public class Period {

    String id;

    int number;

    String type;

    String dateStart;

    String dateFinish;

    int studyYear;

    boolean isCurrent;
}
