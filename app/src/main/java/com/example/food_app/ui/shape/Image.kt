package com.example.food_app.ui.layout

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_app.data.*
import com.example.food_app.function.get_mainImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun regisTogalleryImage() {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val bitmap =  remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(contract = // 갤러리에서 가져오는 이미지는 Uri형식으로 가져옴
    ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }

    imageUri?.let { //
        if (Build.VERSION.SDK_INT < 28) {
            bitmap.value = MediaStore.Images
                .Media.getBitmap(context.contentResolver, it)

        } else {
            val source = ImageDecoder
                .createSource(context.contentResolver, it)
            bitmap.value = ImageDecoder.decodeBitmap(source)
        }
    }

    choiceImage.imageBitmap = bitmap.value

    Row (
        modifier = Modifier.padding(70.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Column {
            Surface(
                modifier = Modifier.fillMaxWidth().border(width = 3.dp, color = Color.Black, shape = RectangleShape),
                shape = RoundedCornerShape(20.dp),
                color = Color.White
            ) {
                if (bitmap.value != null) {
                    bitmap.value?.let { btm ->
                        Image(
                            bitmap = btm.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier.size(width = 200.dp, height = 200.dp)
                        )
                    }
                }
                else Spacer(Modifier.padding(100.dp))

            }

            Spacer(Modifier.padding(5.dp))

            Row {
                Spacer(Modifier.weight(1.0f))
                Button(
                    onClick = {
                        launcher.launch("image/*") // 갤러리 실행시켜주는 메소드
                    },
                    modifier = Modifier.size(width = 100.dp, height = 40.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text("사진 가져오기", color = Color.White, fontSize = 10.sp)
                }
            }
        }
    }
}


@Composable
fun regisToBorderImage() {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val bitmap =  remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(contract = // 갤러리에서 가져오는 이미지는 Uri형식으로 가져옴
    ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }

    imageUri?.let { //
        if (Build.VERSION.SDK_INT < 28) {
            bitmap.value = MediaStore.Images
                .Media.getBitmap(context.contentResolver, it)

        } else {
            val source = ImageDecoder
                .createSource(context.contentResolver, it)
            bitmap.value = ImageDecoder.decodeBitmap(source)
        }
    }

    borderWriteData.borderWriteImageBitmap = bitmap.value

    Row (
        modifier = Modifier.padding(70.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Column {
            Surface(
                modifier = Modifier.fillMaxWidth().border(width = 3.dp, color = Color.Black, shape = RectangleShape),
                shape = RoundedCornerShape(20.dp),
                color = Color.White
            ) {
                if (bitmap.value != null) {
                    bitmap.value?.let { btm ->
                        Image(
                            bitmap = btm.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier.size(width = 200.dp, height = 200.dp)
                        )
                    }
                }
                else Spacer(Modifier.padding(100.dp))

            }

            Spacer(Modifier.padding(5.dp))

            Row {
                Spacer(Modifier.weight(1.0f))
                Button(
                    onClick = {
                        launcher.launch("image/*") // 갤러리 실행시켜주는 메소드
                    },
                    modifier = Modifier.size(width = 100.dp, height = 40.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text("사진 가져오기", color = Color.White, fontSize = 10.sp)
                }
            }
        }
    }
}

@Composable
fun printMainImage() {
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var foods by remember { mutableStateOf("") }
    var showUI by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // 데이터 로드 함수 호출
        get_mainImage()

        // 1초 딜레이 후 상태 업데이트
        delay(3000L)
        bitmap = mainImage.mainImageBitmap
        date = mainImage.mainImageDate.toString()
        time = mainImage.mainEatTime.toString()
        foods = mainImage.mainFood.toString()
        showUI = true // UI를 표시하도록 상태 업데이트
    }

    if (showUI) {
        // UI 구성
        Box(
            modifier = Modifier
                .size(800.dp, 600.dp) // 이미지 크기와 같은 크기로 설정
                .padding(10.dp),
            contentAlignment = Alignment.TopCenter // 이미지를 위쪽 가운데로 정렬
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (bitmap != null) {
                    Text(
                        text = "$date 일 $time 식단 입니다.",
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        bitmap = bitmap!!.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.size(800.dp, 300.dp) // 이미지 크기와 같은 크기로 설정
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "$foods",
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                } else {
                    Text(
                        text = "이미지를 입력해주세요",
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // 이미지와 텍스트 사이의 간격 조정
                    Box(
                        modifier = Modifier
                            .size(800.dp, 300.dp) // 박스 크기와 같은 크기로 설정
                            .background(Color.Gray)
                    )
                }
            }
        }
    }
}


@Composable
fun printMypageImage() {
    val bitmap = mypageImage.mypageImageBitmap
    val foods = mypageImage.mypageFood

    Box(
        modifier = Modifier
            .size(800.dp, 500.dp) // 이미지 크기와 같은 크기로 설정
            .padding(10.dp),
        contentAlignment = Alignment.TopCenter // 이미지를 위쪽 가운데로 정렬
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (bitmap != null) {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.size(800.dp, 300.dp) // 이미지 크기와 같은 크기로 설정
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "$foods",
                    color = Color.Black,
                    fontSize = 20.sp
                )
            } else {

                Text(
                    text = "이미지를 입력해주세요",
                    color = Color.Black,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(16.dp)) // 이미지와 텍스트 사이의 간격 조정 }
                Box(
                    modifier = Modifier
                        .size(800.dp, 300.dp) // 박스 크기와 같은 크기로 설정
                        .background(Color.Gray)
                )
            }
        }
    }
}

@Composable
fun printBorderImage() {

    val bitmap = borderData.borderImageBitmap
    Box(
        modifier = Modifier
            .size(800.dp, 350.dp) // 이미지 크기와 같은 크기로 설정
            .padding(10.dp),
        contentAlignment = Alignment.TopCenter // 이미지를 위쪽 가운데로 정렬
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (bitmap != null) {
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.size(800.dp, 300.dp) // 이미지 크기와 같은 크기로 설정
                )
            }
        }
    }
}