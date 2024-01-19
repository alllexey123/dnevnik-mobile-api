package api.dnevnik.ru.model.response.feed.items;

import api.dnevnik.ru.model.response.marks.Mark;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SubjectMark {

    private List<Mark> marks;
}
