package api.dnevnik.mobile.model.objects.lesson;

import lombok.Data;

@Data
public class Attachment {

    private String extension;

    private String fileId;

    private String fileLink;

    private String fileName;
}
