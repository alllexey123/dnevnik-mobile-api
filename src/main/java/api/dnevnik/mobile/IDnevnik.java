package api.dnevnik.mobile;

import api.dnevnik.mobile.storage.Storage;

public interface IDnevnik {

    Storage getStorage();

    DnevnikApi api();

    String getAccessToken();

    boolean isAuthenticated();
}
