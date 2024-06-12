
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.food_app.data.borderWriteData
import com.example.food_app.function.registerBorder_function

@Composable
fun borderWriteContent(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, start = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "제목",
                fontSize = 18.sp,
                modifier = Modifier.width(60.dp)
            )
            BasicTextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier
                    .width(260.dp)
                    .background(Color(0xFFF6F2F2))
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp, start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "내용",
                fontSize = 18.sp,
                modifier = Modifier.width(60.dp)
            )
            BasicTextField(
                value = content,
                onValueChange = { content = it },
                modifier = Modifier
                    .width(260.dp)
                    .height(200.dp)
                    .background(Color(0xFFF6F2F2))
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    borderWriteData.borderWriteTitle = title
                    borderWriteData.borderWritContent = content
                    registerBorder_function()
                    navController.navigate("usermain") {
                        popUpTo("userMain")
                    }
                },

                modifier = Modifier.size(width = 280.dp, height = 40.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text("글쓰기", color = Color.White, fontSize = 14.sp)
            }
        }
    }
}