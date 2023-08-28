package eif.viko.lt.faculty.app.presentation.ui.gems

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.faculty.app.domain.util.Route
import eif.viko.lt.faculty.app.presentation.ui.gems.components.GemListItem
import eif.viko.lt.faculty.app.presentation.ui.timetable.components.ListItem
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Composable
fun GemsScreen(
    navController: NavController,
    viewModel: GemsViewModel = hiltViewModel()
){
    val state = viewModel.state.gems

    println("DUOMENYS IS API: $state")

    GemListItem(gems = state,
        onItemClick = {

        })
}