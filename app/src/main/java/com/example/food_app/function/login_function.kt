package com.example.food_app.function

import android.util.Log
import androidx.compose.ui.text.input.TextFieldValue
import com.example.food_app.data.serverInfo
import com.example.food_app.data.userInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.Socket

fun login_function(userID: TextFieldValue, passWD: TextFieldValue) {
    val serverAddress = serverInfo.serverAddress
    val port = serverInfo.port
    var userName : String

    CoroutineScope(Dispatchers.IO).launch {
        try {
            // 서버에 연결
            Log.d("LoginFunction", "서버에 연결 시도")
            val clientSocket = Socket(serverAddress, port)
            Log.d("LoginFunction", "서버에 연결됨")
            val writer = OutputStreamWriter(clientSocket.getOutputStream())
            val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))

            writer.write("3\n")

            // 서버에게 REGISTER 요청을 보냄
            writer.write(userID.text + "\n")
            writer.write(passWD.text + "\n")
            writer.flush()

            userName = reader.readLine()

            // 로그인 성공시 계정 정보 오브젝트 형식으로 저장
            userInfo.userID = userID.text
            userInfo.userName = userName
            userInfo.loginCheck = true

            // 연결 종료
            writer.close()
            clientSocket.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}