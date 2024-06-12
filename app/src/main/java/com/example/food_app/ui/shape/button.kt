package com.example.food_app.ui.shape

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.food_app.function.registerImage_function
import com.example.food_app.function.registerLogin_function
import com.example.food_app.function.transferData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun mealsTimeButton(navController: NavController) {
    var selectedButtonIndex by remember { mutableStateOf(0) }
    var isCheckedList by remember { mutableStateOf(listOf(false, false, false)) }

    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row {
                Checkbox(
                    checked = isCheckedList[0],
                    onCheckedChange = {
                        selectedButtonIndex = 1
                        isCheckedList = listOf(true, false, false)
                    },
                    modifier = Modifier
                        .size(width = 24.dp, height = 24.dp)
                        .padding(end = 8.dp)
                )
                Text("아침")
            }

            Row {
                Checkbox(
                    checked = isCheckedList[1],
                    onCheckedChange = {
                        selectedButtonIndex = 2
                        isCheckedList = listOf(false, true, false)
                    },
                    modifier = Modifier
                        .size(width = 24.dp, height = 24.dp)
                        .padding(end = 8.dp)
                )
                Text("점심")
            }

            Row {
                Checkbox(
                    checked = isCheckedList[2],
                    onCheckedChange = {
                        selectedButtonIndex = 3
                        isCheckedList = listOf(false, false, true)
                    },
                    modifier = Modifier
                        .size(width = 24.dp, height = 24.dp)
                        .padding(end = 8.dp)
                )
                Text("저녁")
            }
        }

        Spacer(modifier = Modifier.padding(17.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    registerImage_function(selectedButtonIndex)
                    navController.navigate("userMain") {
                        popUpTo("userMain")
                    }
                },
                modifier = Modifier
                    .size(width = 200.dp, height = 50.dp)
                    .background(Color.Gray)
            ) {
                Text("이미지 등록")
            }
        }
    }
}

@Composable
fun registerButton(
    navController: NavController,
    id: String,
    passwd: String,
    name: String,
) {
    val context = LocalContext.current

    Button(
        onClick = {
            registerLogin_function(id, passwd, name, context)
            navController.navigate("usermain") {
                popUpTo("userMain")
            }
        },

        modifier = Modifier.size(width = 150.dp, height = 40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("회원 가입", color = Color.White, fontSize = 14.sp)
    }
}

@Composable
fun idCheckButton(navController: NavController, userID: TextFieldValue, idCheck: String, setidCheck: (String) -> Unit)
{
    var check : String
    Button(
        onClick = {
            GlobalScope.launch(Dispatchers.IO) {
                transferData(userID, setidCheck)
            }
        },

        modifier = Modifier.size(width = 80.dp, height = 40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("중복 확인", color = Color.White, fontSize = 10.sp)
    }
}


@Composable
fun borderWriteButton(navController: NavController)
{
    Button(
        onClick = {
            navController.navigate("borderWrite") {
                popUpTo("userMain")
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text("글쓰기", color = Color.White, fontSize = 14.sp)
    }
}
