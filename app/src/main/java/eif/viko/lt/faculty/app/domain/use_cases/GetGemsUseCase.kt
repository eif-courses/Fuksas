package eif.viko.lt.faculty.app.domain.use_cases

import eif.viko.lt.faculty.app.data.remote.mappers.GemsDto
import eif.viko.lt.faculty.app.domain.repositories.AuthRepository
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGemsUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(): Flow<Resource<List<GemsDto>>>{
        return repository.myGems();
    }
}
