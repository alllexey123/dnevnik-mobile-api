package api.dnevnik.mobile.model.objects.info;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

@Data
public class School {

    private long id;

    private String name;

    private String type;

    private String avatarUrl;

    @Nullable
    private Double radius;

    @Nullable
    private Double latitude;

    @Nullable
    private Double longitude;
}
