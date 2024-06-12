package com.example.food_app.function

import android.content.Context
import android.widget.Toast
import com.example.food_app.data.serverInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.OutputStreamWriter
import java.net.Socket

fun registerLogin_function(id: String, passwd: String, name: String, context: Context)
{
    val serverAddress = serverInfo.serverAddress
    val port = serverInfo.port

    // 서버에 연결
    GlobalScope.launch(Dispatchers.IO) {
        try {
            // 서버에 연결
            val clientSocket = Socket(serverAddress, port)
            val writer = OutputStreamWriter(clientSocket.getOutputStream())

            writer.write("1\n")

            // 서버에게 REGISTER 요청을 보냄
            writer.write(id + "\n")
            writer.write(passwd+ "\n")
            writer.write(name+ "\n")
            writer.flush()

            // 연결 종료
            writer.close()
            clientSocket.close()

            launch(Dispatchers.Main) {
                Toast.makeText(context, "데이터 전송 성공", Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}