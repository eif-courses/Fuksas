package eif.viko.lt.faculty.app.data.remote
import eif.viko.lt.faculty.app.data.remote.mappers.TimetableGroupDto
import retrofit2.http.GET

interface TimetableApi {
    @GET("/groups.json")
    suspend fun getGroups(): List<TimetableGroupDto>

    companion object{
        const val BASE_URL = "https://spavuenetcore-default-rtdb.firebaseio.com/"
    }
}