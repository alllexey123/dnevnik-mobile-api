package api.dnevnik.mobile.model.objects.diary;

import lombok.Data;

import java.util.List;

@Data
public class DiaryResponse {

    private List<DiaryWeek> weeks;
}
