package eif.viko.lt.faculty.app.presentation.ui.shop.categories

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun ProductCategoriesScreen(
    navController: NavController,
    viewModel: CategoriesViewModel = hiltViewModel()
) {
    val state = viewModel.state.categories

    println("DUOMENYS IS API: $state")

    GemListItem(categories = state,
        onItemClick = {

        })
}