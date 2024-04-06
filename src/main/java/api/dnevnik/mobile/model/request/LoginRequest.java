package api.dnevnik.mobile.model.request;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class LoginRequest {

    @Builder.Default
    Boolean agreeTerms = false;

    @Builder.Default
    String clientId = "1d7bd105-4cd1-4f6c-9ecc-394e400b53bd";

    @Builder.Default
    String clientSecret = "5dcb5237-b5d3-406b-8fee-4441c3a66c99";

    @Builder.Default
    String scope = "Schools,Relatives,EduGroups,Lessons,marks,EduWorks,Avatar";

    String username;

    String password;
}
