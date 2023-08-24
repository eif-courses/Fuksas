package eif.viko.lt.faculty.app.presentation.ui.timetable.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import eif.viko.lt.faculty.app.domain.models.Group

@Composable
fun ListItem(modifier: Modifier = Modifier,
             groups: List<Group>,
             itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
             onItemClick: (Group) -> Unit) {
    LazyColumn(modifier) {
        items(groups.size) { i ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(groups[i]) }
                .padding(16.dp)
            ) {

//                AsyncImage(
//                    modifier = Modifier.width(64.dp),
//                    model = item.PicUrl,
//                    contentDescription = item.Name,
//                )
                //Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = groups[i].name,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
            Divider()
        }
    }
}