package api.dnevnik.mobile.model.objects.marks;

import lombok.Data;

@Data
public class SummativeMark {

    private Float quarterMark;

    private Float sectionMark;

    private String summativeMarkMood;
}
