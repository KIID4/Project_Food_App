package com.example.food_app.ui.shape

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.food_app.data.borderData
import com.example.food_app.data.borderListData
import com.example.food_app.function.get_borderInfo

@Composable
fun borderListShape(navController : NavController) {
    val borderList = borderListData.borderList // borderListData 객체에서 게시글 리스트를 가져옴

    Column(
        Modifier.fillMaxWidth().fillMaxHeight(0.7f)


    ) {
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(borderList) { borderItem ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = 8.dp
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Title: ${borderItem.title}")
                        Text(text = "UserID: ${borderItem.userID}")
                        // 이미지 경로를 표시할 수 있는 UI 요소 추가
                        Button(
                            onClick = {
                                borderData.borderTitle = borderItem.title
                                borderData.borderWriter = borderItem.userID
                                borderData.borderImagePath = borderItem.imagePath
                                get_borderInfo()
                                navController.navigate("border") {
                                    popUpTo("userMain")
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text("Read More")
                        }
                    }
                }
            }
        }
    }
}

