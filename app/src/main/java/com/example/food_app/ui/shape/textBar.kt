package com.example.food_app.ui.shape

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun iDBar(searchInput: TextFieldValue, setter: (TextFieldValue) -> Unit) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),  // width value will be ignored because of fillMaxWidth
            value = searchInput.text,
            singleLine = true,  // 한줄로만 입력
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = null, modifier = Modifier.background(
                        Color.LightGray
                    )
                )
            },
            colors = @OptIn(ExperimentalMaterialApi::class) (ExposedDropdownMenuDefaults.textFieldColors(
                backgroundColor = Color(
                    0xFFE0E0E0
                )
            )),
            onValueChange = { setter(TextFieldValue(it)) },  // 사용자의 새로운 입력을 사용자의 입력을 넣어줌
            placeholder = { Text(text = "아이디", color = Color.Gray) }  // 바탕 글
        )
    }
}

@Composable
fun passwordBar(searchInput: TextFieldValue, setter: (TextFieldValue) -> Unit) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),  // width value will be ignored because of fillMaxWidth
            value = searchInput.text,
            singleLine = true,  // 한줄로만 입력
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock, contentDescription = null, modifier = Modifier.background(
                        Color.LightGray
                    )
                )
            },
            colors = @OptIn(ExperimentalMaterialApi::class) (ExposedDropdownMenuDefaults.textFieldColors(
                backgroundColor = Color(
                    0xFFE0E0E0
                )
            )),
            onValueChange = { setter(TextFieldValue(it)) },  // 사용자의 새로운 입력을 사용자의 입력을 넣어줌
            placeholder = { Text(text = "비밀번호", color = Color.Gray) }  // 바탕 글
        )
    }
}