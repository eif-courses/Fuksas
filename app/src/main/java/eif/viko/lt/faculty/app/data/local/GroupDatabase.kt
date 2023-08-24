package eif.viko.lt.faculty.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [GroupEntity::class],
    version = 1,
    exportSchema = true
)
abstract class GroupDatabase: RoomDatabase() {
    abstract val dao: GroupDao
}