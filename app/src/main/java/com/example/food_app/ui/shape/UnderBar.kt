// BottomAppBar.kt

package com.example.food_app.ui.shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.food_app.R
import com.example.food_app.data.userInfo
import com.example.food_app.function.get_borderList

@Composable
fun bottomAppBar(navController: NavController) {

    val customcolor = Color(0xff4E7FFF)
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color(0xff4E7FFF)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), // Add padding for better spacing
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
               navController.navigate("userMain") {
                   launchSingleTop = true
                   popUpTo("userMain") {
                       inclusive = true
                   }
               }
            },
                modifier = Modifier.size(width = 60.dp, height = 50.dp).
                shadow(0.dp, shape = CircleShape).
                clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = customcolor)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "home",
                    contentScale = ContentScale.Crop
                )
            }

            Button(onClick = {
                if(userInfo.loginCheck) {
                    navController.navigate("regisImage") {
                        popUpTo("userMain")
                    }
                }

                else {
                    navController.navigate("login") {
                        popUpTo("userMain")
                    }
                }
            },
                modifier = Modifier.size(width = 70.dp, height = 50.dp).
                clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = customcolor)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = "camera",
                    contentScale = ContentScale.Crop
                )
            }

            Button(onClick = {
                if(userInfo.loginCheck) {
                    navController.navigate("mypage") {
                        popUpTo("userMain")
                    }
                }

                else {
                    navController.navigate("login") {
                        popUpTo("userMain")
                    }
                }
            },
                modifier = Modifier.size(width = 70.dp, height = 50.dp).
                clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = customcolor)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.note),
                    contentDescription = "note",
                    contentScale = ContentScale.Crop
                )
            }

            Button(onClick = {
                if(userInfo.loginCheck) {
                    get_borderList()
                    navController.navigate("borderList") {
                        popUpTo("userMain")
                    }
                }

                else {
                    navController.navigate("login") {
                        popUpTo("userMain")
                    }
                }
            },
                modifier = Modifier.size(width = 70.dp, height = 50.dp).
                clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = customcolor)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bulletin),
                    contentDescription = "bulletin",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

