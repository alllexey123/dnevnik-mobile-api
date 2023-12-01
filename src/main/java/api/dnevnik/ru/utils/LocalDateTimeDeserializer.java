package api.dnevnik.ru.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;

public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            long epochSecond = Long.parseLong(json.getAsString());
            return LocalDateTime.ofEpochSecond(epochSecond, 0, ZoneOffset.UTC);
        } catch (NumberFormatException nfe) {
            try {
                return LocalDateTime.parse(json.getAsString());
            } catch (DateTimeParseException e) {
                return null;
            }
        }
    }
}
