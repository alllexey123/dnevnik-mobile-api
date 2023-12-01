package api.dnevnik.ru.model.response;

import lombok.Value;

@Value
public class Hours {

    String startHour;

    String startMinute;

    String endHour;

    String endMinute;
}
