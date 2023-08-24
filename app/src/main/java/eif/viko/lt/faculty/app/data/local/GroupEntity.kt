package eif.viko.lt.faculty.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import eif.viko.lt.faculty.app.domain.models.Group

@Entity
data class GroupEntity(
    @PrimaryKey val id: Long? = null,
    val name: String
) {
    fun toGroup() = Group(name = name)
}