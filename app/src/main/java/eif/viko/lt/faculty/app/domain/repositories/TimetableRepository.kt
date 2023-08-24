package eif.viko.lt.faculty.app.domain.repositories

import eif.viko.lt.faculty.app.domain.models.Group
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface TimetableRepository{
    fun getGroups(): Flow<Resource<List<Group>>>
}