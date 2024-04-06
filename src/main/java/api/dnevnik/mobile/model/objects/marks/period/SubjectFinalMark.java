package api.dnevnik.mobile.model.objects.marks.period;

import api.dnevnik.mobile.model.objects.marks.Mark;
import api.dnevnik.mobile.model.objects.MetaData;
import api.dnevnik.mobile.model.objects.Restrictable;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class SubjectFinalMark implements Restrictable {

    private OffsetDateTime date;

    private long id;

    private boolean isNew;

    private long itemId;

    private String markType;

    private String markTypeText;

    private List<Mark> marks;

    private MetaData metadata;

    private int periodNumber;

    private String criteriaMarkType;

    private String workType;
}
