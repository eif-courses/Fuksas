package eif.viko.lt.faculty.app.presentation.ui.timetable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun GroupDetailsScreen(
    navController: NavController,
    viewModel: TimetableViewModel = hiltViewModel(),
    name: String?,
) {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = listOf(Color.Blue, Color.Cyan, Color.Green)
                        )
                    )
                ) {
                    append("Grupė: ${name}")
                }
            }, style = MaterialTheme.typography.displayLarge
        )
    }
}

@Preview
@Composable
fun Testing() {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = listOf(Color.Blue, Color.Cyan, Color.Green)
                        )
                    )
                ) {
                    append("Grupe IS25A")
                }
            }, style = MaterialTheme.typography.displayLarge
        )
    }
}
