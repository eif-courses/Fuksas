package eif.viko.lt.faculty.app.presentation.ui.timetable

import eif.viko.lt.faculty.app.domain.models.Group

data class GroupState(
    val groups: List<Group> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)