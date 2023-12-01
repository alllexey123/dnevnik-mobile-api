package api.dnevnik.ru.model.response.info;

import lombok.Value;
import org.jetbrains.annotations.Nullable;

@Value
public class School {

    int id;

    String name;

    String type;

    String avatarUrl;

    @Nullable
    Double radius;

    @Nullable
    Double latitude;

    @Nullable
    Double longitude;
}
