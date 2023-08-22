package eif.viko.lt.faculty.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import eif.viko.lt.faculty.app.domain.util.Route
import eif.viko.lt.faculty.app.presentation.ui.categories.CategoriesScreen
import eif.viko.lt.faculty.app.presentation.ui.categories.CategoryDetailsScreen


@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Route.CATEGORIES_SCREEN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Route.CATEGORIES_SCREEN) {
            CategoriesScreen(navController = navController)
        }
        composable(route = Route.CATEGORY_DETAILS_SCREEN) {
            CategoryDetailsScreen(navController = navController)
        }

    }
}