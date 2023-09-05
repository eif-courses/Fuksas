package eif.viko.lt.faculty.app.data.repositories

import android.content.SharedPreferences
import eif.viko.lt.faculty.app.data.remote.AuthApi
import eif.viko.lt.faculty.app.data.remote.mappers.GemsDto
import eif.viko.lt.faculty.app.domain.models.AuthRequest
import eif.viko.lt.faculty.app.domain.repositories.AuthRepository
import eif.viko.lt.faculty.app.domain.util.AuthResult
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.FormBody
import retrofit2.HttpException

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val prefs: SharedPreferences
) : AuthRepository {

    override suspend fun signUp(username: String, password: String): AuthResult<Unit> {
        return try {
            api.signUp(
                request = AuthRequest(
                    username = username,
                    password = password
                )
            )
            signIn(username, password)
        } catch (e: HttpException) {
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }
    }

    override suspend fun signIn(username: String, password: String): AuthResult<Unit> {
        return try {

            val response = api.signIn(
                    grantType = "password",
                    username = username,
                    password = password

            )
            println("KOSMOSAS:" + response.access_token)

            prefs.edit()
                .putString("jwt", response.access_token)
                .apply()
            AuthResult.Authorized()
        } catch (e: HttpException) {
            e.printStackTrace()
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            AuthResult.UnknownError()
        }
    }

    override suspend fun authenticate(): AuthResult<Unit> {
        return try {
            val token = prefs.getString("jwt", null) ?: return AuthResult.Unauthorized()
            api.authenticate("Bearer $token")
            AuthResult.Authorized()
        } catch (e: HttpException) {
            if (e.code() == 401) {
                // Update with new token using expired token
                val result =
                    api.refreshToken(token = "Bearer${prefs.getString("jwt", null).toString()}")
                prefs.edit()
                    .putString("jwt", result.access_token)
                    .apply()
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }
    }

//    override fun myGems(): Flow<Resource<List<GemsDto>>> = flow {
//        val token = prefs.getString("jwt", null)
//        emit(Resource.Loading())
//        val remoteGroupsData = api.getMyGems("Bearer $token")
//        emit(Resource.Loading(data = remoteGroupsData))
//    }


}