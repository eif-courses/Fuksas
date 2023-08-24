package eif.viko.lt.faculty.app.presentation.ui.categories

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import eif.viko.lt.faculty.app.R
import eif.viko.lt.faculty.app.domain.util.Route

data class GridItem(
    val category: String,
    val icon: ImageVector,
    val route: String
)

val courseList = listOf(
    GridItem("Tvarkaraštis", Icons.Filled.Info, Route.GROUP_SCREEN),
    GridItem("Biblioteka", Icons.Filled.Create,Route.CATEGORIES_SCREEN),
    GridItem("IT Paslaugos", Icons.Filled.Build,Route.CATEGORIES_SCREEN),
    GridItem("Kontaktai", Icons.Filled.AccountBox,Route.CATEGORIES_SCREEN),
    GridItem("El. paštas", Icons.Filled.Email,Route.CATEGORIES_SCREEN),
    GridItem("Muziejus", Icons.Filled.DateRange,Route.CATEGORIES_SCREEN),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cards(navController: NavController) {

    var text by remember { mutableStateOf("") }
    val context = LocalContext.current
    val rememberedContext = remember { { context } }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(10.dp)
    ) {
        items(courseList.size) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                onClick = {
                    text = courseList[it].category
                    Toast.makeText(rememberedContext(), text, Toast.LENGTH_SHORT).show()
                    navController.navigate(courseList[it].route)
                          }, colors = CardDefaults.cardColors(
                    //contentColor = Color.Red,
                    //containerColor = Color.LightGray
                )
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        imageVector =  courseList[it].icon,
                        contentDescription = courseList[it].category,
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .padding(5.dp)
                    )
                    Spacer(modifier = Modifier.height(9.dp))

                    Text(
                        text = courseList[it].category,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun CategoriesScreen(navController: NavController) {
    Cards(navController = navController)
}

@Preview
@Composable
fun CategoriesPreview() {
    //CategoriesScreen()
}
