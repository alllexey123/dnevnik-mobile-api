package api.dnevnik.ru;

import api.dnevnik.ru.storage.Storage;
import okhttp3.OkHttpClient;

public interface IDnevnik {

    Storage getStorage();

    DnevnikApi api();

    OkHttpClient getDefaultClient();

    String getAccessToken();

    boolean isAuthenticated();

    String refreshAccessToken();

}
