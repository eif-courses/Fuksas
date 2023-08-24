package eif.viko.lt.faculty.app.data.remote.mappers

import eif.viko.lt.faculty.app.data.local.GroupEntity

data class TimetableGroupDto(
    val bell: String="",
    val classroomid: String="",
    val classroomids: List<Any> = emptyList(),
    val color: String="",
    val id: String="",
    val name: String="",
    val printsubjectpictures: Boolean = false,
    val short: String = "",
    val teacherid: String ="",
    val timeoff: List<List<List<String>>> = emptyList()
)
{
    fun toGroupEntity(): GroupEntity{
        return GroupEntity(name=name)
    }

}