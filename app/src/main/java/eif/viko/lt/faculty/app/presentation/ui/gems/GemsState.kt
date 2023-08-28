package eif.viko.lt.faculty.app.presentation.ui.gems
import eif.viko.lt.faculty.app.data.remote.mappers.GemsDto
data class GemsState (
    val isLoading: Boolean = false,
    val error: String? = null,
    val gems: List<GemsDto> = emptyList()
)