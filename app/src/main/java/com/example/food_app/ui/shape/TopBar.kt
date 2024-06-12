package com.example.food_app.ui.shape

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.food_app.data.userInfo
import com.example.food_app.function.logout

@Composable
fun topAppBar(navController: NavController) {
    val loginCheck = userInfo.loginCheck
    val userName = userInfo.userName

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color(0xff4E7FFF)
    )  {
        Column(Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically  // Text 위젯들 간 세로 중앙 정렬 위함
            ) {

                if(userName != "NULL") {
                    Text(text = userName, color = Color.White, fontSize = 18.sp)
                }
                else{
                    Text(text = " ", color = Color.White, fontSize = 18.sp)
                }

                Spacer(Modifier.weight(1.0f))

                if (loginCheck) { // 로그인 성공시
                    Text(text = "로그아웃", color = Color.White, fontSize = 20.sp, modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null, // 버튼 중복 방지
                            enabled = true,
                            onClickLabel = null,
                            role = null,
                            onClick = {
                                logout()
                                navController.navigate("userMain") {
                                    popUpTo("login")
                                }
                            }
                        )
                    )
                }

                else{
                    Text(text = "로그인", color = Color.White, fontSize = 20.sp, modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() }, // 상호작용 이벤트
                            indication = null, // 버튼 중복 방지
                            enabled = true, // UI 활성화 여부
                            onClickLabel = null, // 클릭 이벤트에 대한 접근성 레이블
                            role = null,
                            onClick = { // 클릭 이벤트 핸들러
                                navController.navigate("Login") {
                                    popUpTo("userMain")
                                }
                            }
                        )
                    )
                }
            }
            Spacer(Modifier.padding(6.dp))
        }
    }
}

