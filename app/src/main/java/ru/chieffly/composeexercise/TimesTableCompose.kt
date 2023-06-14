package ru.chieffly.composeexercise

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 *Created by Bryantsev Anton on 14.06.2023.
 **/

@Composable
fun TimesTable() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        for (i in 1 until 10) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                for (j in 1 until 10) {
                    val color = if ((i + j) % 2 == 0) {
                        Color.Yellow
                    } else {
                        Color.White
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(color = color)
                            .border(1.dp, Color.Gray),
                        contentAlignment = Alignment.Center,

                        ) {
                        Text((i * j).toString())
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TimesTable()
}