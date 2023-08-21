package eif.viko.lt.faculty.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import eif.viko.lt.faculty.app.R
import eif.viko.lt.faculty.app.presentation.ui.theme.FuksasTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FuksasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(data: MyCard, modifier: Modifier = Modifier) {
    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.border(1.dp, Color.Blue).fillMaxWidth(1f)
        ){
        Image(painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Test image")
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FuksasTheme {

        val colorNamesList = listOf(
            MyCard("Red", Color.Red),
            MyCard("Green", Color.Green),
            MyCard("Blue", Color.Blue),
            MyCard("Magneta", Color.Magenta)
        )

        LazyColumn {
            itemsIndexed(colorNamesList) { index, item ->
                Greeting(item)
            }
        }


    }
}