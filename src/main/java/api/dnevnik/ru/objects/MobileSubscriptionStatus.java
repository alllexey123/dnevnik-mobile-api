package api.dnevnik.ru.objects;

import com.google.gson.annotations.SerializedName;

public enum MobileSubscriptionStatus {
    @SerializedName("Active")
    ACTIVE,
    @SerializedName("NotActive")
    NOT_ACTIVE
}
