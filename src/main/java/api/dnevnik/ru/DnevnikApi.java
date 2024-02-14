package api.dnevnik.ru;

import api.dnevnik.ru.model.request.*;
import api.dnevnik.ru.model.response.BasicResponse;
import api.dnevnik.ru.model.response.EsiaLinkedUsersResponse;
import api.dnevnik.ru.model.response.EsiaLoginResponse;
import api.dnevnik.ru.model.response.EsiaRegionsResponse;
import api.dnevnik.ru.model.objects.feed.FeedResponse;
import api.dnevnik.ru.model.response.LoginResponse;
import api.dnevnik.ru.model.response.RefreshTokenResponse;
import api.dnevnik.ru.model.objects.info.UserContext;
import api.dnevnik.ru.model.response.FinalMarksResponse;
import api.dnevnik.ru.model.response.PeriodMarksResponse;
import api.dnevnik.ru.model.response.SubjectDetailsResponse;
import retrofit2.http.*;

import java.util.concurrent.CompletableFuture;

public interface DnevnikApi {

    @POST("/mobile/v8.5/authorizations/bycredentials")
    CompletableFuture<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("/mobile/v8.5/users/{userId}/context")
    CompletableFuture<UserContext> getUserContext(@Header("Access-Token") String accessToken, @Path("userId") Long userId);

    @POST("/mobile/v8.5/subscriptions/google/validate")
    CompletableFuture<BasicResponse> validatePayment(@Header("Access-Token") String accessToken, @Body ValidatePaymentRequest paramValidatePaymentRequest);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/important")
    CompletableFuture<FeedResponse> getUserFeed(@Header("Access-Token") String accessToken, @Path("personId") long personId, @Path("groupId") long groupId);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/finalMarks")
    CompletableFuture<FinalMarksResponse> getFinalGrades(@Header("Access-Token") String accessToken, @Path("personId") long personId, @Path("groupId") long groupId);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/subjects/{subjectId}/periods/{periodId}/subjectDetails")
    CompletableFuture<SubjectDetailsResponse> getSubjectDetails(@Header("Access-Token") String accessToken, @Path("personId") long personId, @Path("groupId") long groupId, @Path("subjectId") long subjectId, @Path("periodId") long periodId);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/periods/{periodId}/periodMarks")
    CompletableFuture<PeriodMarksResponse> getPeriodMarks(@Header("Access-Token") String accessToken, @Path("personId") long personId, @Path("groupId") long groupId, @Path("periodId") long periodId);

    @POST("/mobile/v8.5/authorizations/byrefreshtoken")
    CompletableFuture<RefreshTokenResponse> refreshToken(@Body RefreshTokenRequest refreshTokenRequest);

    @POST("/mobile/v8.5/authorizations/esia/")
    CompletableFuture<EsiaLoginResponse> esiaLogin(@Body EsiaLoginRequest esiaLoginRequest);

    @POST("/mobile/v8.5/authorizations/esia/users/linked")
    CompletableFuture<EsiaLinkedUsersResponse> getEsiaLinkedUsers(@Body EsiaTaskWrapper esiaTaskWrapper);

    @GET("/mobile/v8.5/authorizations/esia/regions")
    CompletableFuture<EsiaRegionsResponse> getEsiaRegions();

}
