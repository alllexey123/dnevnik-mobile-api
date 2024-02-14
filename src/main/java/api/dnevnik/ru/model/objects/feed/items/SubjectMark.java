package api.dnevnik.ru.model.objects.feed.items;

import api.dnevnik.ru.model.objects.marks.Mark;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SubjectMark {

    private List<Mark> marks;
}
