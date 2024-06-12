package com.example.food_app.function

import android.graphics.BitmapFactory
import android.util.Base64
import com.example.food_app.data.mainImage
import com.example.food_app.data.serverInfo
import com.example.food_app.data.userInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.Socket

fun get_mainImage() {
    val serverAddress = serverInfo.serverAddress
    val port = serverInfo.port
    val userId = userInfo.userID

    GlobalScope.launch(Dispatchers.IO) {
        try {
            // 서버에 연결
            val clientSocket = Socket(serverAddress, port)
            val writer = OutputStreamWriter(clientSocket.getOutputStream())
            val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))

            writer.write("5\n")
            writer.write("$userId\n")
            writer.flush()

            // 서버에게 REGISTER 요청을 보냄
            val encodedImage = reader.readLine()
            val date = reader.readLine()
            val eattime = reader.readLine()
            val foods = reader.readLine()

            if (encodedImage != null) {
                // Base64 인코딩된 이미지를 디코딩하여 Bitmap으로 변환
                val decodedBytes = Base64.decode(encodedImage, Base64.DEFAULT)
                val bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)

                // 로그인 성공 시 계정 정보 오브젝트 형식으로 저장
                mainImage.mainImageBitmap = bitmap
                mainImage.mainImageDate = date
                mainImage.mainEatTime = eattime
                mainImage.mainFood = foods
            }

            // 연결 종료
            writer.close()
            reader.close()
            clientSocket.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
