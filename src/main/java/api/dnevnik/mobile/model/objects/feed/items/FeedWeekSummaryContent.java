package api.dnevnik.mobile.model.objects.feed.items;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class FeedWeekSummaryContent implements FeedItemContent {

    private LocalDate date;

    private List<WeekSummary> items;

    @Override
    public FeedItemType getItemType() {
        return FeedItemType.WEEK_SUMMARY;
    }
}
