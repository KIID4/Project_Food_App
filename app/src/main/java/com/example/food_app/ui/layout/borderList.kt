package com.example.food_app.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.food_app.ui.shape.borderListShape
import com.example.food_app.ui.shape.borderWriteButton
import com.example.food_app.ui.shape.bottomAppBar
import com.example.food_app.ui.shape.topAppBar

@Composable
fun borderList(navController : NavController) {
    Column(
        Modifier.fillMaxSize()
    ) {
        topAppBar(navController)
        Spacer(Modifier.weight(0.2f))
        borderListShape(navController)
        Spacer(Modifier.weight(0.2f))
        borderWriteButton(navController)
        Spacer(Modifier.weight(0.6f))
        bottomAppBar(navController)
    }
}