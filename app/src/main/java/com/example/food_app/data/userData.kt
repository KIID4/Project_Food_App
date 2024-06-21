package com.example.food_app.data

import android.graphics.Bitmap


object userInfo { // 사용자 로그인 정보
    var userID : String = "NULL"
    var userName : String = "NULL"
    var loginCheck : Boolean = false
}

object choiceImage { // 사용자가 판별할 이미지 데이터
    var imageBitmap : Bitmap? = null
}

object mainImage { // 메인페이지에 출력할 이미지 데이터
    var mainImageBitmap : Bitmap? = null
    var mainImageDate : String? = null
    var mainEatTime : String? = null
    var mainFood: String? = null
    var foodKcal : String? = null
}

object mypageImage { // 사용자가 선택한 날짜의 이미지 데이터
    var mypageImageBitmap : Bitmap? = null
    var mypageFood: String? = null
    var mypageSelectDate : String? = null
    var mypageSelectTime : String? = null
}

data class BorderItem(
    val title: String,
    val userID: String,
    val imagePath: String
)

object borderListData {
    var borderList: List<BorderItem> = emptyList()
}

object borderData { // 다른 사용자의 게시판 출력을 위한 데이터
    var borderImageBitmap : Bitmap? = null
    var borderTitle : String? = null
    var borderWriter : String? = null
    var borderContent : String? = null
    var borderImagePath : String? = null
}

object borderWriteData { // 게시판 작성을 위한 데이터
    var borderWritImageBitmap : Bitmap? = null
    var borderWriteTitle : String? = null
    var borderWritContent : String? = null
}

