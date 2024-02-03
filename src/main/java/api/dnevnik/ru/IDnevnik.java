package api.dnevnik.ru;

import api.dnevnik.ru.exceptions.DnevnikApiException;
import api.dnevnik.ru.storage.Storage;

public interface IDnevnik {

    Storage getStorage();

    DnevnikApi api();

    String getAccessToken();

    boolean isAuthenticated();

    String refreshAccessToken() throws DnevnikApiException;

}
