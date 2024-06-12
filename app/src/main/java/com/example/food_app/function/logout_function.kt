package com.example.food_app.function

import com.example.food_app.data.userInfo


fun logout() {
    userInfo.userID = "NULL"
    userInfo.userName = "NULL"
    userInfo.loginCheck = false
}