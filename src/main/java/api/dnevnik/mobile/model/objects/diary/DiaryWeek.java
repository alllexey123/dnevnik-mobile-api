package api.dnevnik.mobile.model.objects.diary;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class DiaryWeek {

    // date of the first day of the week in the format "yyyy-MM-dd"
    private String id;

    private int homeworksCount;

    private OffsetDateTime firstWeekDayDate;

    private OffsetDateTime lastWeekDayDate;

    private List<DiaryDay> days;

}
