package eif.viko.lt.faculty.app.domain.repositories

import eif.viko.lt.faculty.app.domain.util.AuthResult

interface AuthRepository {
    suspend fun signUp(username: String, password: String): AuthResult<Unit>
    suspend fun signIn(username: String, password: String): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>
}