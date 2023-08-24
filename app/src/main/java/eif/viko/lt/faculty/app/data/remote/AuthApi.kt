package eif.viko.lt.faculty.app.data.remote

import eif.viko.lt.faculty.app.domain.models.AuthRequest
import eif.viko.lt.faculty.app.domain.models.TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {

    @POST("registration")
    suspend fun signUp(
        @Body request: AuthRequest
    )

    @POST("login")
    suspend fun signIn(
        @Body request: AuthRequest
    ): TokenResponse

    @GET("users/me")
    suspend fun authenticate(
        @Header("Authorization") token: String
    )
}