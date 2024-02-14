package api.dnevnik.ru.model.objects.lesson;

import api.dnevnik.ru.model.objects.MetaData;
import api.dnevnik.ru.model.objects.Restrictable;
import lombok.Data;

import java.util.List;

@Data
public class Homework implements Restrictable {

    private List<Attachment> attachments;

    private Boolean isCompleted;

    private MetaData metadata;

    private String text;

    private Boolean workIdAttachRequired;

}
