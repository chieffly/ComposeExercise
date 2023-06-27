package ru.chieffly.composeexercise

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.chieffly.composeexercise.ui.theme.ComposeExerciseTheme

/**
 *Created by Bryantsev Anton on 14.06.2023.
 **/


@Composable
fun InstagramProfileCard() {
    Card(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_instagram),
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(8.dp)
                )


                DoubleText("461", "Posts")
                DoubleText("234M", "Followers")
                DoubleText("79", " Following")

            }

            Text(
                text = "Instagram",
                fontSize = 32.sp,
                fontFamily = FontFamily.Cursive,
            )
            Text(
                text = "#YoursToMake",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
            )
            Text(
                text = "www.facebook.com/yourstomake",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
            )
            Button(onClick = {  }) {
                Text(text = "Follow")
            }
        }
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
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Composable
fun Counters() {


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