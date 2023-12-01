package api.dnevnik.ru.model.response.feed.items;

import api.dnevnik.ru.model.response.lessons.Mark;
import lombok.Value;

import java.util.List;

@Value
public class SubjectMark {

    List<Mark> marks;
}
