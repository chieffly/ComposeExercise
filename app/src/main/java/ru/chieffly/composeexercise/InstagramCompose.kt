package ru.chieffly.composeexercise

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.chieffly.composeexercise.ui.theme.ComposeExerciseTheme

/**
 *Created by Bryantsev Anton on 14.06.2023.
 **/

@Composable
fun Counters() {

    Row(
        modifier = Modifier
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
        )
        DoubleText("461", "Posts")
        DoubleText("234M", "Followers")
        DoubleText("79", " Following")

    }
}

@Composable
private fun DoubleText(number: String, name: String) {
    Column(
        modifier = Modifier.height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = number,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = name,
            fontSize = 14.sp
        )
    }
}

@Composable
fun InstagramProfileCard() {
    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
        backgroundColor = MaterialTheme.colors.background,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Counters()
    }
}

@Preview
@Composable
fun InstagramPreviewLight() {
    ComposeExerciseTheme(darkTheme = false) {
        InstagramProfileCard()
    }
}

@Preview
@Composable
fun InstagramPreviewDark() {
    ComposeExerciseTheme(darkTheme = true) {
        InstagramProfileCard()
    }
}