package eif.viko.lt.faculty.app.presentation.ui.shop.products


sealed class ProductUiEvents {

    object CreateNewProduct: ProductUiEvents()

    object CreateNewCategory: ProductUiEvents()
    object DeleteCategoryById: ProductUiEvents()
    object GetCategoryById : ProductUiEvents()
}