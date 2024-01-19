package api.dnevnik.ru.model.response.diary;

import api.dnevnik.ru.model.response.MetaData;
import api.dnevnik.ru.model.response.Restrictable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Lesson implements Restrictable {

    private Long id;

    private LocalDate date;

    private String theme;

    private MetaData metadata;
}
