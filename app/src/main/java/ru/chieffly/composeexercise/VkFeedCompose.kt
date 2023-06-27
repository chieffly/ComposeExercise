package ru.chieffly.composeexercise

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 *Created by Bryantsev Anton on 27.06.2023.
 **/

@Composable
fun VkFeedCard(){
    Card(modifier = Modifier
        .padding(4.dp),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Column() {
            VkCardTopper()
            Text(text = "текст поста",modifier =  Modifier.padding(4.dp))
            Image(painter = ColorPainter(Color.Green), contentDescription = "", modifier =  Modifier.padding(4.dp).size(400.dp))
            VkBottomPane()
        }
    }
}

@Composable
fun VkCardTopper() {
    Row() {
        Image(painter = ColorPainter(Color.Green), contentDescription = "", modifier = Modifier
            .size(60.dp)
            .padding(4.dp)
            .clip(CircleShape))
        Column(modifier = Modifier.padding(8.dp,0.dp)) {
            Text(text = "Название группы")
            Text(text = "15:20")
        }
    }
}

@Composable
fun VkBottomPane() {
    Row(modifier = Modifier.padding(8.dp)) {
        IconWithCount("90", R.drawable.ic_eye_24)
        IconWithCount("206", R.drawable.baseline_share_24)
        IconWithCount("11", R.drawable.baseline_message_24)
        IconWithCount("458", R.drawable.baseline_favorite_border_24)
    }
}

@Composable
fun IconWithCount(count: String, drawableId: Int){
    Row() {
        Text(text = count,modifier = Modifier.padding(4.dp))
        Image(painter = painterResource(drawableId), contentDescription = "")
    }
}

@Preview
@Composable
fun PreviewVK() {
    VkFeedCard()
}