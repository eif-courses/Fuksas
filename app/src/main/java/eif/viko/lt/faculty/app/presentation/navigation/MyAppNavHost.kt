package eif.viko.lt.faculty.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import eif.viko.lt.faculty.app.domain.util.Route
import eif.viko.lt.faculty.app.presentation.ui.auth.AuthScreen
import eif.viko.lt.faculty.app.presentation.ui.categories.CategoriesScreen
import eif.viko.lt.faculty.app.presentation.ui.categories.CategoryDetailsScreen
import eif.viko.lt.faculty.app.presentation.ui.gems.ProductCategoriesScreen
import eif.viko.lt.faculty.app.presentation.ui.timetable.GroupDetailsScreen
import eif.viko.lt.faculty.app.presentation.ui.timetable.GroupsScreen


@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Route.AUTH_SCREEN
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
        composable(route=Route.GROUP_SCREEN){
            GroupsScreen(navController = navController)
        }
        composable(route=Route.AUTH_SCREEN){
            AuthScreen(navController = navController)
        }
        composable(route=Route.PRODUCT_CATEGORIES_SCREEN){
            ProductCategoriesScreen(navController = navController)
        }
        composable(
            route = "${Route.GROUP_DETAILS_SCREEN}/{name}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            GroupDetailsScreen(
                navController = navController,
                name = backStackEntry.arguments?.getString("name")
            )
        }

    }
}