package com.example.food_app.function

import androidx.compose.ui.text.input.TextFieldValue
import com.example.food_app.data.serverInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.Socket

fun transferData(userID: TextFieldValue, setidCheck: (String) -> Unit) {
    val serverAddress = serverInfo.serverAddress
    val port = serverInfo.port

    GlobalScope.launch(Dispatchers.IO) {
        try {
            // 서버에 연결
            val clientSocket = Socket(serverAddress, port)
            val writer = OutputStreamWriter(clientSocket.getOutputStream())
            val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
            val check : String

            writer.write("2\n")

            // 서버에게 REGISTER 요청을 보냄
            writer.write(userID.text + "\n")
            writer.flush()

            check = reader.readLine()
            setidCheck(check)

            // 연결 종료
            writer.close()
            clientSocket.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}