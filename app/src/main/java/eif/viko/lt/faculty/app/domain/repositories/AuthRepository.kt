package eif.viko.lt.faculty.app.domain.repositories

import eif.viko.lt.faculty.app.data.remote.mappers.GemsDto
import eif.viko.lt.faculty.app.domain.util.AuthResult
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signUp(username: String, password: String): AuthResult<Unit>
    suspend fun signIn(username: String, password: String): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>
    fun myGems(): Flow<Resource<List<GemsDto>>>
}