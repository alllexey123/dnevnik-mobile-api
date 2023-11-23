package api.dnevnik.ru;


import api.dnevnik.ru.methods.DnevnikMethods;
import okhttp3.OkHttpClient;

public interface IDnevnik {

    String getAccessToken();

    String getRefreshToken();

    long getUserId();

    OkHttpClient getDefaultClient();

    boolean isAuthenticated();

    DnevnikMethods methods();

}
