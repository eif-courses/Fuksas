package eif.viko.lt.faculty.app.presentation.ui.gems.components

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
import eif.viko.lt.faculty.app.data.remote.mappers.GemsDto

@Composable
fun GemListItem(modifier: Modifier = Modifier,
             gems: List<GemsDto>,
             itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
             onItemClick: (GemsDto) -> Unit) {
    LazyColumn(modifier) {
        items(gems.size) { i ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(gems[i]) }
                .padding(16.dp)
            ) {

//                AsyncImage(
//                    modifier = Modifier.width(64.dp),
//                    model = item.PicUrl,
//                    contentDescription = item.Name,
//                )
                //Spacer(modifier = Modifier.width(16.dp))
                gems[i].gem?.let {
                    Text(
                        text = it.gem_type,
                        style = itemTextStyle,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Divider()
        }
    }
}