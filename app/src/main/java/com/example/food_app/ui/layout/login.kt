package com.example.food_app.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.food_app.ui.shape.bottomAppBar
import com.example.food_app.ui.shape.loginBox
import com.example.food_app.ui.shape.topAppBar

@Composable
fun login(navController : NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        topAppBar(navController)
        Spacer(Modifier.weight(0.5f))
        loginBox(navController)
        Spacer(Modifier.weight(0.5f))
        bottomAppBar(navController)
    }
}