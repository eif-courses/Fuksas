package eif.viko.lt.faculty.app.presentation.ui.shop.products

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import eif.viko.lt.faculty.app.domain.util.Route

@Composable
fun ProductDetailsScreen(
    navController: NavController,
    name: String?,
    description: String?,
    price: Float?,
    quantity: Int?
) {
    Column {
        Text(text = "$name, $description, $price, $quantity")

        Button(onClick = { navController.navigate(Route.PRODUCTS_SCREEN) }) {
            Text(text = "ATGAL")
        }
    }
}