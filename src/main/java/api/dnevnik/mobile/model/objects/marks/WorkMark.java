package api.dnevnik.mobile.model.objects.marks;

import lombok.Data;

import java.util.List;

@Data
public class WorkMark {

    private List<Mark> marks;

    private long workId;
}
