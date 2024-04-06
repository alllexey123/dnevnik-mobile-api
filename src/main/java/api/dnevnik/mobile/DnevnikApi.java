package api.dnevnik.mobile;

import api.dnevnik.mobile.model.objects.feed.FeedResponse;
import api.dnevnik.mobile.model.objects.info.UserContext;
import api.dnevnik.mobile.model.request.*;
import api.dnevnik.mobile.model.response.*;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.*;

public interface DnevnikApi {


    @POST("/mobile/v8.5/authorizations/bycredentials")
    Single<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("/mobile/v8.5/users/{userId}/context")
    Single<UserContext> getUserContext(@Header("Access-Token") String accessToken, @Path("userId") Long userId);

    @POST("/mobile/v8.5/subscriptions/google/validate")
    Single<BasicResponse> validatePayment(@Header("Access-Token") String accessToken, @Body ValidatePaymentRequest paramValidatePaymentRequest);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/important")
    Single<FeedResponse> getUserFeed(@Header("Access-Token") String accessToken, @Path("personId") long personId, @Path("groupId") long groupId);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/finalMarks")
    Single<FinalMarksResponse> getFinalGrades(@Header("Access-Token") String accessToken, @Path("personId") long personId, @Path("groupId") long groupId);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/subjects/{subjectId}/periods/{periodId}/subjectDetails")
    Single<SubjectDetailsResponse> getSubjectDetails(@Header("Access-Token") String accessToken, @Path("personId") long personId, @Path("groupId") long groupId, @Path("subjectId") long subjectId, @Path("periodId") long periodId);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/periods/{periodId}/periodMarks")
    Single<PeriodMarksResponse> getPeriodMarks(@Header("Access-Token") String accessToken, @Path("personId") long personId, @Path("groupId") long groupId, @Path("periodId") long periodId);

    @POST("/mobile/v8.5/authorizations/byrefreshtoken")
    Single<RefreshTokenResponse> refreshToken(@Body RefreshTokenRequest refreshTokenRequest);

    @POST("/mobile/v8.5/authorizations/esia/")
    Single<EsiaLoginResponse> esiaLogin(@Body EsiaLoginRequest esiaLoginRequest);

    @POST("/mobile/v8.5/authorizations/esia/users/linked")
    Single<EsiaLinkedUsersResponse> getEsiaLinkedUsers(@Body EsiaTaskWrapper esiaTaskWrapper);

    @GET("/mobile/v8.5/authorizations/esia/regions")
    Single<EsiaRegionsResponse> getEsiaRegions();

}
