package api.dnevnik.ru.model.response.info;

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
