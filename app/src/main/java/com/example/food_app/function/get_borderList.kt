package com.example.food_app.function

import com.example.food_app.data.BorderItem
import com.example.food_app.data.borderListData
import com.example.food_app.data.serverInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.Socket

fun get_borderList() {
    val serverAddress = serverInfo.serverAddress
    val port = serverInfo.port

    GlobalScope.launch(Dispatchers.IO) {
        try {
            // 서버에 연결
            val clientSocket = Socket(serverAddress, port)
            val writer = OutputStreamWriter(clientSocket.getOutputStream())
            val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))

            writer.write("7\n")
            writer.flush()

            // 서버에서 받은 데이터를 읽어옴
            val data = reader.readText()

            // 데이터를 파싱하여 BorderItem 객체로 변환하여 borderListData에 저장
            val borderList = data.split("\n").map { line ->
                val parts = line.split(",")
                BorderItem(parts[0], parts[1], parts[2]) // 제목, 유저 아이디, 이미지 경로를 BorderItem 객체로 만듦
            }
            borderListData.borderList = borderList

            // 연결 종료
            writer.close()
            reader.close()
            clientSocket.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}