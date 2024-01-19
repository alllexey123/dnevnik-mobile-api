package api.dnevnik.ru.model.response.diary;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Subject implements Restrictable {

    private Long id;

    private String name;

    private String knowledgeArea;

    private String subjectMood;

    private MetaData metadata;
}
