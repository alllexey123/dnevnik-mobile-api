package api.dnevnik.mobile.model.objects.feed.items;

import com.google.gson.annotations.SerializedName;

public enum FeedItemType {

    @SerializedName("Banner") BANNER,

    @SerializedName("ImportantWork") IMPORTANT_WORK,

    @SerializedName("AskTeacher") ASK_TEACHER,

    @SerializedName("WeekSummary") WEEK_SUMMARY,

    @SerializedName("Post") POST
}
