package eif.viko.lt.faculty.app.presentation.ui.shop.products

import eif.viko.lt.faculty.app.data.remote.mappers.Products

data class ProductsState (
    val isLoading: Boolean = false,
    val error: String? = null,
    var name: String = "",
    var id : Int = 4,
    val products: Products? = null
)