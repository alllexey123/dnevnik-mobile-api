package api.dnevnik.ru;

import api.dnevnik.ru.model.request.LoginRequest;
import api.dnevnik.ru.model.request.ValidatePaymentRequest;
import api.dnevnik.ru.model.response.BasicResponse;
import api.dnevnik.ru.model.response.feed.FeedResponse;
import api.dnevnik.ru.model.response.info.LoginResponse;
import api.dnevnik.ru.model.response.info.UserContext;
import api.dnevnik.ru.model.response.marks.FinalMarksResponse;
import api.dnevnik.ru.model.response.marks.PeriodMarksResponse;
import api.dnevnik.ru.model.response.marks.SubjectDetailsResponse;
import retrofit2.http.*;

import java.util.concurrent.CompletableFuture;

public interface DnevnikApi {

    @POST("/mobile/v8.5/authorizations/bycredentials")
    CompletableFuture<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("/mobile/v8.5/users/{userId}/context")
    CompletableFuture<UserContext> getUserContext(@Path("userId") Long userId);

    @POST("/mobile/v8.5/subscriptions/google/validate")
    CompletableFuture<BasicResponse> validatePayment(@Body ValidatePaymentRequest paramValidatePaymentRequest);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/important")
    CompletableFuture<FeedResponse> getUserFeed(@Path("groupId") long groupId, @Path("personId") long personId);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/finalMarks")
    CompletableFuture<FinalMarksResponse> getFinalGrades(@Path("personId") long personId, @Path("groupId") long groupId);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/subjects/{subjectId}/periods/{periodId}/subjectDetails")
    CompletableFuture<SubjectDetailsResponse> getSubjectDetails(@Path("personId") long personId, @Path("groupId") long groupId, @Path("subjectId") long subjectId, @Path("periodId") long periodId);

    @GET("/mobile/v8.5/persons/{personId}/groups/{groupId}/periods/{periodId}/periodMarks")
    CompletableFuture<PeriodMarksResponse> getPeriodMarks(@Path("personId") long personId, @Path("groupId") long groupId, @Path("periodId") long periodId);

}
