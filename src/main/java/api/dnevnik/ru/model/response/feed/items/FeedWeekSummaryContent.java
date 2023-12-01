package api.dnevnik.ru.model.response.feed.items;

import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class FeedWeekSummaryContent implements FeedItemContent {

    LocalDate date;

    List<WeekSummary> items;
}
