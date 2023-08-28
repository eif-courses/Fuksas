package eif.viko.lt.faculty.app.data.repositories

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import eif.viko.lt.faculty.app.data.local.GroupDao
import eif.viko.lt.faculty.app.data.remote.TimetableApi
import eif.viko.lt.faculty.app.domain.models.Group
import eif.viko.lt.faculty.app.domain.repositories.TimetableRepository
import eif.viko.lt.faculty.app.domain.util.Resource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import java.io.IOException

import javax.inject.Inject

class TimetableRepositoryImpl @Inject constructor(
    private val api: TimetableApi,
    private val dao: GroupDao
) : TimetableRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getGroups(): Flow<Resource<List<Group>>> = flow {

        emit(Resource.Loading())


        val groups = dao.getGroupsFromDB().map { it.toGroup() }

        emit(Resource.Loading(data = groups))


        try {
            //if (dao.getGroupsFromDB().isEmpty()) {
                val remoteGroupsData = api.getGroups()
                dao.insertGroupsToDB(remoteGroupsData.map { it.toGroupEntity() })
           // }
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    "Something whent wrong!",
                    data = groups
                )
            )

        } catch (e: IOException) {
            emit(
                Resource.Error(
                    "Error can't reach server, check your internet connection!",
                    data = groups
                )
            )
        }

    }

}