package eif.viko.lt.faculty.app.data.remote.mappers

data class ProductPageCategory(
    val id: Int = 0,
    val name: String = ""
)
data class ProductPageItem(
    val category: ProductPageCategory? = null,
    val description: String = "",
    val id: Int = 0,
    val name: String = "",
    val price: Int = 0,
    val quantity: Int = 0
)

data class ProductPageDto(
    val items: List<ProductPageItem> = emptyList(),
    val page: Int = 0,
    val pages: Int = 0,
    val size: Int = 0,
    val total: Int = 0
)