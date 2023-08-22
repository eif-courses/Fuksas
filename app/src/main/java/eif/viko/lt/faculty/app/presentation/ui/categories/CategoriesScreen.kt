package eif.viko.lt.faculty.app.presentation.ui.categories

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import eif.viko.lt.faculty.app.R
@Composable
fun Cards(data: MyCard, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(1.dp, Color.Blue)
            .fillMaxWidth(1f).clickable(onClick = onClick)
    ) {
        Image(
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Test image"
        )
        Column {
            Text(
                text = data.name,
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = data.color
            )
        }
    }
}
data class MyCard(val name: String, val color: Color)
@Composable
fun CategoriesScreen(navController: NavController? = null) {

    var text by remember { mutableStateOf("") }
    val context = LocalContext.current
    val rememberedContext = remember { { context } }
    val itemsIndexedList = listOf("Labas", "Kaip", "Sekas")
    LazyColumn {
        items(itemsIndexedList) {
            Cards(
                data = MyCard(it,
                color = Color.Green),
                onClick = {
                    text = it
                    Toast.makeText(rememberedContext(), text, Toast.LENGTH_SHORT).show()
                })
        }

    }
}
@Preview
@Composable
fun CategoriesPreview() {
    CategoriesScreen()
}
