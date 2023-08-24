package eif.viko.lt.faculty.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroupsToDB(groups: List<GroupEntity>)

    @Query("SELECT * FROM groupentity")
    suspend fun getGroupsFromDB(): List<GroupEntity>
}