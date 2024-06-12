package com.example.food_app.ui.shape

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_app.data.borderData

@Composable
fun printBorderInfo() {

    val title = borderData.borderTitle
    val writer = borderData.borderWriter
    val content = borderData.borderContent

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, start = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "제목",
                fontSize = 18.sp,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .width(260.dp)
                    .background(Color(0xFFF6F2F2)) // 배경색
                    .border(1.dp, Color.Black) // 테두리
                    .padding(8.dp)
            ) {
                Text(
                    text = "$title",
                    fontSize = 18.sp
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, start = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "작성자",
                fontSize = 18.sp,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .width(260.dp)
                    .background(Color(0xFFF6F2F2)) // 배경색
                    .border(1.dp, Color.Black) // 테두리
                    .padding(8.dp)
            ) {
                Text(
                    text = "$writer",
                    fontSize = 18.sp
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, start = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "내용",
                fontSize = 18.sp,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .width(260.dp)
                    .height(300.dp)
                    .background(Color(0xFFF6F2F2)) // 배경색
                    .border(1.dp, Color.Black) // 테두리
                    .padding(8.dp)
            ) {
                Text(
                    text = "$content",
                    fontSize = 18.sp
                )
            }
        }
    }
}