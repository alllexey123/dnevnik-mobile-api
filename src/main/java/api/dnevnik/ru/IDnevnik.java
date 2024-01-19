package api.dnevnik.ru;

import api.dnevnik.ru.storage.Storage;

public interface IDnevnik {

    Storage getStorage();

    DnevnikApi api();

    String getAccessToken();

    boolean isAuthenticated();

    String refreshAccessToken();

}
