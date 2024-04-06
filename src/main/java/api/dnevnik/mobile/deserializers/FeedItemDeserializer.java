package api.dnevnik.mobile.deserializers;

import api.dnevnik.mobile.model.objects.feed.items.*;
import com.google.gson.*;

import java.lang.reflect.Type;

public class FeedItemDeserializer implements JsonDeserializer<FeedItem> {

    private final Gson gson = new Gson();

    @Override
    public FeedItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject feedItemJson = json.getAsJsonObject();

        FeedItemType type = context.deserialize(feedItemJson.get("type"), FeedItemType.class);

        if (type == null) {
            throw new IllegalArgumentException("There is no mapping for feed item type '" + feedItemJson.get("type") + "'. JSON: " + gson.toJson(feedItemJson));
        }

        FeedItemContent content = context.deserialize(feedItemJson.get("content"), getContentClass(type));
        return new FeedItem(type, content);
    }


    public Class<? extends FeedItemContent> getContentClass(FeedItemType type) {
        switch (type) {
            case BANNER:
                return FeedBannerContent.class;
            case IMPORTANT_WORK:
                return FeedImportantWorkContent.class;
            case ASK_TEACHER:
                return FeedAskTeacherContent.class;
            case WEEK_SUMMARY:
                return FeedWeekSummaryContent.class;
            case POST:
                return FeedPostContent.class;
        }
        return FeedBannerContent.class;
    }
}
