package eif.viko.lt.faculty.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import eif.viko.lt.faculty.app.domain.models.Group

@Database(
    entities = [GroupEntity::class],
    version = 1,
    exportSchema = true
)
abstract class GroupDatabase: RoomDatabase() {
    abstract val dao: GroupDao
}