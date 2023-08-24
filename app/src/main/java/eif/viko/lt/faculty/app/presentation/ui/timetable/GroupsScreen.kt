package eif.viko.lt.faculty.app.presentation.ui.timetable

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.faculty.app.domain.util.Route
import eif.viko.lt.faculty.app.presentation.ui.timetable.components.ListItem
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Composable
fun GroupsScreen(
    navController: NavController,
    viewModel: TimetableViewModel = hiltViewModel()
){
    val state = viewModel.state.groups

    println("DUOMENYS IS API: $state")

    ListItem(
        groups = state,
        onItemClick = {
            val encodedUrl = URLEncoder.encode(it.name, StandardCharsets.UTF_8.toString())
            navController.navigate(Route.GROUP_DETAILS_SCREEN+"/${encodedUrl}")
        })
}