package eif.viko.lt.faculty.app.data.local


import androidx.room.*

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroupsToDB(groups: List<GroupEntity>)

    @Query("SELECT * FROM groupentity")
    suspend fun getGroupsFromDB(): List<GroupEntity>
}