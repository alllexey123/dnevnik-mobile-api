package api.dnevnik.ru.model.objects.lesson;

import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
import api.dnevnik.ru.model.objects.marks.WorkMark;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class Lesson implements Restrictable {

    private Long id;

    private LocalDate date;

    private Boolean hasAttachment;

    private Homework homework;

    private Hours hours;

    private List<String> importantWorks;

    private Boolean isCancelled;

    private boolean isEmpty;

    private Integer number;

    private String place;

    private Subject subject;

    private List<WorkMark> workMarks;

    private String theme;

    private MetaData metadata;
}
