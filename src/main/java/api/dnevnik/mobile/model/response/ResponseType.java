package api.dnevnik.mobile.model.response;

import com.google.gson.annotations.SerializedName;

public enum ResponseType {

    @SerializedName("Error") ERROR,

    @SerializedName("invalidRequest") INVALID_REQUEST,

    @SerializedName("tokenRequired") TOKEN_REQUIRED,

    @SerializedName("Success") SUCCESS,

    @SerializedName("parameterInvalid") PARAMETER_INVALID,

    @SerializedName("authorizationFailed") AUTHORIZATION_FAILED

}

