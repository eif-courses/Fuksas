package eif.viko.lt.faculty.app.presentation.ui.gems

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.faculty.app.presentation.ui.gems.components.GemListItem


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