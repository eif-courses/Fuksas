package eif.viko.lt.faculty.app.presentation.ui.shop.products

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.faculty.app.data.remote.mappers.Products
import eif.viko.lt.faculty.app.domain.models.Category
import eif.viko.lt.faculty.app.domain.util.Route
import eif.viko.lt.faculty.app.presentation.ui.shop.products.components.ProductCards

@Composable
fun ProductsScreen(
    navController: NavController,
    viewModel: ProductsViewModel = hiltViewModel()
) {
    val state = viewModel.state.products

    state?.let {
        ProductCards(
            products = it.items, onItemClick = {product ->
                navController.navigate(
                    Route.PRODUCT_DETAILS_SCREEN +"/${product.name}/${product.description}/${product.price}/${product.quantity}"
                )
            })
    }
    println("DUOMENYS IS API: $state")


}