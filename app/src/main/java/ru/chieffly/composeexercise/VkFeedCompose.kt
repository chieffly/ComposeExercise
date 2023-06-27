package ru.chieffly.composeexercise

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.chieffly.composeexercise.ui.theme.ComposeExerciseTheme

/**
 *Created by Bryantsev Anton on 27.06.2023.
 **/

@Composable
fun VkFeedCard() {
    Card(
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            VkCardTopper()
            Text(text = "текст поста", modifier = Modifier.padding(4.dp))
            Image(
                painter = ColorPainter(Color.Green), contentDescription = "", modifier = Modifier
                    .padding(4.dp)
                    .size(400.dp)
            )
            VkBottomPane()
        }
    }
}

@Composable
fun VkCardTopper() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = ColorPainter(Color.Green), contentDescription = "", modifier = Modifier
                .size(60.dp)
                .padding(4.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
        ) {
            Text(
                text = "Название группы",
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "15:20",
                color = MaterialTheme.colors.onSecondary
            )
        }
        Icon(painter = painterResource(R.drawable.baseline_more_vert_24), contentDescription = "", tint = MaterialTheme.colors.onSecondary)
    }
}

@Composable
fun VkBottomPane() {
    Row {
        Row(modifier = Modifier.weight(1f)) {
            IconWithCount(R.drawable.ic_eye_24, "90")
        }
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceBetween) {
            IconWithCount(R.drawable.baseline_share_24, "206")
            IconWithCount(R.drawable.baseline_message_24, "11")
            IconWithCount(R.drawable.baseline_favorite_border_24, "458")
        }
    }
}

@Composable
fun IconWithCount(drawableId: Int, count: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = painterResource(drawableId), contentDescription = "", tint = MaterialTheme.colors.onSecondary)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = count, color = MaterialTheme.colors.onSecondary)
    }
}

@Preview
@Composable
private fun PreviewVKLight() {
    ComposeExerciseTheme(darkTheme = false) {
        VkFeedCard()

    }
}

@Preview
@Composable
private fun PreviewVKDark() {
    ComposeExerciseTheme(darkTheme = true) {
        VkFeedCard()
    }
}