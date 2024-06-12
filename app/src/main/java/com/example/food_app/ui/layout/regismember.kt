package com.example.food_app.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.food_app.ui.shape.bottomAppBar
import com.example.food_app.ui.shape.joinMember
import com.example.food_app.ui.shape.topAppBar

@Composable
fun registerMember(navController : NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        topAppBar(navController)
        Spacer(Modifier.weight(0.2f))
        joinMember(navController)
        Spacer(Modifier.weight(0.2f))
        bottomAppBar(navController)
    }
}
