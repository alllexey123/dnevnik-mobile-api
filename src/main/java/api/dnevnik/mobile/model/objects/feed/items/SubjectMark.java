package api.dnevnik.mobile.model.objects.feed.items;

import api.dnevnik.mobile.model.objects.marks.Mark;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.StringJoiner;

@Data
@NoArgsConstructor
public class SubjectMark {

    private List<Mark> marks;

    public String marksToString() {
        StringJoiner sj = new StringJoiner("/");
        marks.stream().map(Mark::getValue).forEach(sj::add);
        return sj.toString();
    }
}
