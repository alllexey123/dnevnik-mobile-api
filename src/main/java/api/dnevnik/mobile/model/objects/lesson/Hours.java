package api.dnevnik.mobile.model.objects.lesson;

import lombok.Data;

@Data
public class Hours {

    private String startHour;

    private String startMinute;

    private String endHour;

    private String endMinute;
}
