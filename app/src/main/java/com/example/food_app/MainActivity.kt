package com.example.food_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.food_app.ui.layout.*
import com.example.food_app.ui.theme.Food_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Food_AppTheme {
                val navController = rememberNavController()  // 화면이동 담당 객체

                NavHost(
                    navController = navController,
                    startDestination = "userMain"
                ) {
                    composable("userMain") { // 메인화면
                        userMain(navController)
                    }

                    composable("login") { // 로그인 화면
                        login(navController)
                    }

                    composable("registerMember") { // 회원가입 화면
                        registerMember(navController)
                    }

                    composable("regisImage") { // 이미지 등록 화면
                        regisImage(navController)
                    }

                    composable("mypage") { // 마이페이지 화면
                        mypage(navController)
                    }

                    composable("borderList") { // 게시판 리스트 화면
                        borderList(navController)
                    }

                    composable("borderWrite") { // 게시판 작성 화면
                        borderWrite(navController)
                    }

                    composable("border") { // 게시판 작성 화면
                        border(navController)
                    }
                }
            }
        }
    }
}

