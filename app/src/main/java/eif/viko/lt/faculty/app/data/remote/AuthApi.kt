package eif.viko.lt.faculty.app.data.remote
import eif.viko.lt.faculty.app.domain.models.AuthRequest
import eif.viko.lt.faculty.app.domain.models.RefreshToken
import eif.viko.lt.faculty.app.domain.models.TokenResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {

    @POST("registration")
    suspend fun signUp(
        @Body request: AuthRequest
    )

    @FormUrlEncoded
    @POST("login")
    suspend fun signIn(
        @Field("grant_type") grantType: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): TokenResponse


    @GET("users/me")
    suspend fun authenticate(
        @Header("Authorization") token: String
    )


    @POST("refresh")
    @Headers("Content-Type: application/json")
    suspend fun refreshToken(@Body token: RefreshToken): TokenResponse



//    @GET("gems/seller/me")
//    suspend fun getMyGems(
//        @Header("Authorization") token: String
//    ): List<GemsDto>


    companion object {
        const val BASE_URL = "https://onlinecourses-production.up.railway.app/"
    }
}