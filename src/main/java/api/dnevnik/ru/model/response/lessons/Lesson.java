package api.dnevnik.ru.model.response.lessons;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Value;

import java.time.LocalDate;

@Value
public class Lesson implements Restrictable {

    long id;

    LocalDate date;

    String theme;

    MetaData metadata;
}
