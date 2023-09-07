package eif.viko.lt.faculty.app.presentation.ui.shop.products.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import eif.viko.lt.faculty.app.data.remote.mappers.ProductItem
import eif.viko.lt.faculty.app.presentation.ui.categories.courseList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCards(
    products: List<ProductItem> = emptyList(),
    onItemClick: (ProductItem) -> Unit
) {

    var text by remember { mutableStateOf("") }
    val context = LocalContext.current
    val rememberedContext = remember { { context } }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(10.dp)
    ) {
        items(products.size) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                onClick = {
                    onItemClick(products[it])
                },

                colors = CardDefaults.cardColors(
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
                        imageVector = courseList[0].icon,
                        contentDescription = products[it].description,
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .padding(5.dp)
                    )
                    Spacer(modifier = Modifier.height(9.dp))

                    Text(
                        text = products[it].name,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}