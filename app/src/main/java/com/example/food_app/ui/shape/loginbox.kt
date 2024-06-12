package com.example.food_app.ui.shape

import android.annotation.SuppressLint
import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.food_app.data.userInfo
import com.example.food_app.function.login_function

@SuppressLint("ShowToast")
@Composable
fun loginBox(navController : NavController) {
    val context = LocalContext.current

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically  // Text 위젯들 간 세로 중앙 정렬 위함
    )  {
        val (ID, setID) = remember { mutableStateOf(TextFieldValue()) }
        val (passWD, setPassWD) = remember { mutableStateOf(TextFieldValue()) }

        Column(Modifier.padding(20.dp)){
            iDBar(ID, setID)
            Spacer(Modifier.padding(1.dp))
            passwordBar(passWD, setPassWD)
            Spacer(Modifier.padding(10.dp))
            Button(onClick = {
                login_function(ID, passWD)
                var logincheck = userInfo.loginCheck
                if(logincheck){
                    navController.navigate("userMain") {
                        popUpTo("registerMember")
                    }
                }
                else {
                    val message = Toast.makeText(context, "ID 및 PW를 다시확인해주십시오", Toast.LENGTH_SHORT)
                    message.setGravity(Gravity.CENTER, 0, 0) // 토스트 메세지 가운데 지정
                    message.show()
                }
            },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff070000))
            ) {
                Text("로그인", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
            }

            Button(onClick = {
                navController.navigate("registerMember") {
                    popUpTo("login")
                }
            },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff070000))
            ) {
                Text("회원가입", color = Color.White, fontSize = 17.sp, textAlign = TextAlign.Center)
            }
        }
    }
}