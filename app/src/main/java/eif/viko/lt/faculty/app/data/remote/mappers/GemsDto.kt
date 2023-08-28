package eif.viko.lt.faculty.app.data.remote.mappers

data class GemsDto(
    val gem: Gem? = null,
    val props: Props? = null
)

data class Props(
    val clarity: Int=0,
    val color: String="",
    val id: Int=0,
    val size: Double=0.0
)
data class Gem(
    val available: Boolean = false,
    val gem_properties_id: Int = 0,
    val gem_type: String = "",
    val id: Int=0,
    val price: Int=0,
    val seller_id: Int=0
)