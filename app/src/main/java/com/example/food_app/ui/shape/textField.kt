package com.example.food_app.ui.shape

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun joinMember(navController : NavController) {

    val (id, setID) = remember { mutableStateOf(TextFieldValue()) }
    val (passWD, setPassWD) = remember { mutableStateOf(TextFieldValue()) }
    val (repassWD, setRepassWD) = remember { mutableStateOf(TextFieldValue()) }
    val (name, setName) = remember { mutableStateOf(TextFieldValue()) }
    val (idCheck, setidCheck) = remember { mutableStateOf<String>("") }

    Column(Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(15.dp))
            Text("ID", fontSize = 16.sp)
            Spacer(Modifier.padding(20.dp))
            informationBar("아이디 입력 ", 200, 55, id, setID)
            Spacer(Modifier.weight(0.1f))
            idCheckButton(navController, id, idCheck, setidCheck)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(15.dp))
            if (idCheck.isNotEmpty()) {
                Text(
                    text = if (idCheck == "false") "사용가능한 아이디 입니다." else "중복되는 아이디입니다.",
                    fontSize = 16.sp
                )
            }
            else {
                Text(
                    text = "id를 입력해주세요",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(Modifier.padding(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(12.dp))
            Text("PW", fontSize = 16.sp)
            Spacer(Modifier.padding(18.dp))
            informationBar("비밀번호 입력", 200, 55, passWD, setPassWD)
            Spacer(Modifier.weight(0.9f))
        }

        Spacer(Modifier.padding(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(8.dp))
            Text("PW확인", fontSize = 16.sp)
            Spacer(Modifier.padding(8.2.dp))
            informationBar("비밀번호 재입력", 200, 55, repassWD, setRepassWD)
            Spacer(Modifier.weight(0.9f))
        }

        Spacer(Modifier.padding(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (passWD.text.isNotEmpty() && repassWD.text.isNotEmpty()) {
                if (passWD.text == repassWD.text) {
                    Text("비밀번호가 일치합니다.")
                } else {
                    Text("비밀번호가 일치하지 않습니다.")
                }
            }
        }

        Spacer(Modifier.padding(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(10.dp))
            Text("이름", fontSize = 16.sp)
            Spacer(Modifier.padding(17.dp))
            informationBar("사용자 이름 입력", 200, 55, name, setName)
            Spacer(Modifier.weight(0.9f))
        }

        Spacer(Modifier.padding(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Center
        ) {
            registerButton(navController, id.text, passWD.text, name.text)
        }
    }
}
@Composable
fun informationBar(text: String, xValue : Int, yValue : Int, typing: TextFieldValue, setter: (TextFieldValue) -> Unit) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier.size(width = xValue.dp, height = yValue.dp),
            shape = RoundedCornerShape((10.dp)),
            value = typing.text,
            singleLine = true,  // 한줄로만 입력

            colors = @OptIn(ExperimentalMaterialApi::class) (ExposedDropdownMenuDefaults.textFieldColors(
                backgroundColor = Color(
                    0xFFE0E0E0
                )
            )),
            onValueChange = { setter(TextFieldValue(it)) },  // 사용자의 새로운 입력을 사용자의 입력에 넣어줌
            placeholder = { Text(text = text, color = Color.Gray, fontSize = 10.sp) }  // 바탕 글
        )
    }
}