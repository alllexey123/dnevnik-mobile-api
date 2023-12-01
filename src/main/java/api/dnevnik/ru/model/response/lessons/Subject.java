package api.dnevnik.ru.model.response.lessons;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Value;

@Value
public class Subject implements Restrictable {

    long id;

    String name;

    String knowledgeArea;

    String subjectMood;

    MetaData metadata;
}
