package api.dnevnik.ru.model.objects.info;

import lombok.Data;

@Data
public class Period {

    private long id;

    private int number;

    private String type;

    private String dateStart;

    private String dateFinish;

    private int studyYear;

    private boolean isCurrent;
}
