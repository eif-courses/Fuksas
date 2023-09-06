package eif.viko.lt.faculty.app.presentation.ui.gems.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eif.viko.lt.faculty.app.R
import eif.viko.lt.faculty.app.domain.models.Category

@Composable
fun GemListItem(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (Category) -> Unit
) {
    LazyColumn(modifier) {
        items(categories.size) { i ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(categories[i]) }
                .padding(16.dp)
            ) {

//                AsyncImage(
//                    modifier = Modifier.width(64.dp),
//                    model = item.PicUrl,
//                    contentDescription = item.Name,
//                )
                //Spacer(modifier = Modifier.width(16.dp))
                if (categories[i].id <= 1) {
                    Image(
                        painter = painterResource(id = R.drawable.diamond),
                        contentDescription = "Kosmosas", modifier.width(50.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.emerald),
                        contentDescription = "Kosmosas", modifier.width(42.dp)
                    )
                }

                Text(
                    text = categories[i].name,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )

            }
            Divider()
        }
    }
}