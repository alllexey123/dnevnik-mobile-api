package api.dnevnik.mobile.deserializers;

import api.dnevnik.mobile.model.objects.info.Credentials;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class CredentialsDeserializer implements JsonDeserializer<Credentials> {
    @Override
    public Credentials deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        Credentials credentials = new Credentials();
        credentials.setAccessToken(jsonObject.get("accessToken").getAsString());
        credentials.setRefreshToken(jsonObject.get("refreshToken").getAsString());
        credentials.setScope(jsonObject.get("scope").getAsString());
        if (jsonObject.has("expiresDate")) {
            credentials.setExpiresDate(context.deserialize(jsonObject.get("expiresDate"), OffsetDateTime.class));
        } else if (jsonObject.has("expiresIn")) {
            credentials.setExpiresDate(OffsetDateTime.now(ZoneId.of("UTC")).plusSeconds(jsonObject.get("expiresIn").getAsLong()));
        }
        if (jsonObject.has("userId")) {
            credentials.setUserId(jsonObject.get("userId").getAsLong());
        } else if (jsonObject.has("user")) {
            credentials.setUserId(jsonObject.get("user").getAsLong());
        }

        return credentials;
    }
}
