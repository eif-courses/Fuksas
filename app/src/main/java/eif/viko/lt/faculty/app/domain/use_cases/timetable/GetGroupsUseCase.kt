package eif.viko.lt.faculty.app.domain.use_cases.timetable

import eif.viko.lt.faculty.app.domain.models.Group
import eif.viko.lt.faculty.app.domain.repositories.TimetableRepository
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGroupsUseCase @Inject constructor(
    private val repository: TimetableRepository
){
    operator fun invoke(): Flow<Resource<List<Group>>>{
        return repository.getGroups()
    }
}