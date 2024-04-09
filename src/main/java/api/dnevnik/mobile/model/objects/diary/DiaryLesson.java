package api.dnevnik.mobile.model.objects.diary;

import api.dnevnik.mobile.model.objects.info.Group;
import api.dnevnik.mobile.model.objects.lesson.Homework;
import api.dnevnik.mobile.model.objects.lesson.Subject;
import api.dnevnik.mobile.model.objects.marks.WorkMark;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DiaryLesson {

    private long id;

    private int number;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private boolean isCanceled;

    private String theme;

    private Subject subject;

    private List<String> importantWorks;

    private Homework homework;

    private List<WorkMark> workMarks;

    private Teacher teacher;

    private Group group;
}
