package eif.viko.lt.faculty.app.data.remote.mappers

data class ProductCategory(
    val id: Int = 0,
    val name: String = ""
)

data class ProductItem(
    val category: ProductCategory? = null,
    val description: String = "",
    val id: Int = 0,
    val name: String = "",
    val price: Int = 0,
    val quantity: Int = 0
)

data class ProductLinks(
    val first: String? = null,
    val last: String? = null,
    val next: String? = null,
    val prev: String? = null,
    val self: String? = null
)

data class Products(
    val items: List<ProductItem> = emptyList(),
    val links: ProductLinks? = null,
    val page: Int = 0,
    val pages: Int = 0,
    val size: Int = 0,
    val total: Int = 0
)