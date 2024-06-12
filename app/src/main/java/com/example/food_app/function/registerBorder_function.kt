package com.example.food_app.function

import android.graphics.Bitmap
import android.util.Base64
import com.example.food_app.data.borderWriteData
import com.example.food_app.data.serverInfo
import com.example.food_app.data.userInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.Socket
import java.util.*

fun registerBorder_function() {
    val serverAddress = serverInfo.serverAddress
    val port = serverInfo.port

    val bitmap = borderWriteData.borderWritImageBitmap
    val userId = userInfo.userID
    val title = borderWriteData.borderWriteTitle
    val content = borderWriteData.borderWritContent
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH) + 1 // Calendar.MONTH는 0부터 시작하므로 +1 필요
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    var check : String? = null
    // 날짜와 시간을 설정
    var date: String = "$year-$month-$day"

    // Bitmap을 바이트 배열로 변환
    val byteArrayOutputStream = ByteArrayOutputStream()

    if (bitmap != null) {
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
    }

    val byteArray = byteArrayOutputStream.toByteArray()
    val encodedImage = Base64.encodeToString(byteArray, Base64.NO_WRAP)

    GlobalScope.launch(Dispatchers.IO) {
        try {
            // 서버에 연결
            val clientSocket = Socket(serverAddress, port)
            val writer = OutputStreamWriter(clientSocket.getOutputStream())
            val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))

            writer.write("9\n")
            // 서버에게 REGISTER 요청을 보냄
            writer.write(userId + "\n")
            writer.write(date + "\n")
            writer.write(title + "\n")
            writer.write(content + "\n")
            writer.write(encodedImage)
            writer.flush()

            // 연결 종료
            writer.close()
            reader.close()
            clientSocket.close()

            launch(Dispatchers.Main) {
                //Toast.makeText(context, "데이터 전송 성공", Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception) {
            e.printStackTrace()
            launch(Dispatchers.Main) {
                //Toast.makeText(context, "데이터 전송 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }
}