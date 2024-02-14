package api.dnevnik.ru.model.objects.info;

import lombok.Data;

@Data
public class Region {

    private int regionId;

    private String esiaUrl;

    private String name;

    // it's always "https://static.dnevnik.ru/images/blank.jpg"
    private String logoUrl;

}
