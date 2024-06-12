package com.example.food_app.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.food_app.ui.shape.bottomAppBar
import com.example.food_app.ui.shape.mealsTimeButton
import com.example.food_app.ui.shape.topAppBar

@Composable
fun regisImage(navController : NavController) {
    Column(
        Modifier.fillMaxSize()
    ) {
        topAppBar(navController)
        regisTogalleryImage()
        mealsTimeButton(navController)
        Spacer(Modifier.weight(1f))
        bottomAppBar(navController)
    }
}