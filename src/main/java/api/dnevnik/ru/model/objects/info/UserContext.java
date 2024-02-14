package api.dnevnik.ru.model.objects.info;

import api.dnevnik.ru.model.response.BasicResponse;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserContext extends BasicResponse {

    private Info info;

    private List<Person> contextPersons;

    public Person getPerson() {
        return contextPersons.get(0);
    }

    public List<Period> getPeriods() {
        return getPerson().getReportingPeriodGroup().getPeriods();
    }

    // returns the current or last period, if any
    public Period getCurrentPeriod() {
        Period result = null;
        for (Period p : getPeriods()) {
            if (p.isCurrent()) return p;
            result = p;
        }
        return result;
    }

    @Data
    public static class Info {

        private String sex;

        private long userId;

        private long personId;

        private String firstName;

        private String middleName;

        private String lastName;

        @Nullable
        private String avatarUtl;

        private String currentCultureCode;
    }

}
