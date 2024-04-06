package api.dnevnik.mobile.model.objects.lesson;

import api.dnevnik.mobile.model.objects.MetaData;
import api.dnevnik.mobile.model.objects.Restrictable;
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
