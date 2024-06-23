
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.food_app.data.mypageImage
import com.example.food_app.function.get_mypageImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun dateList(navController: NavController) {
    var selectedYear by remember { mutableStateOf(2024) }
    var selectedMonth by remember { mutableStateOf(6) }
    var selectedDay by remember { mutableStateOf(9) }
    var selectedMeal by remember { mutableStateOf("Morning") }
    val coroutineScope = rememberCoroutineScope()

    val years = (2023..2024).toList()
    val months = (1..12).toList()
    val days = (1..31).toList()
    val meals = listOf("Morning", "Lunch", "Dinner")

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Year selection
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
                    .border(2.dp, Color.Gray)  // 테두리 추가
                    .padding(8.dp)
            ) {
                Text("년", fontSize = 16.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(years) { year ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .clickable { selectedYear = year }
                                .fillMaxWidth()
                                .border(
                                    1.dp,
                                    if (selectedYear == year) MaterialTheme.colors.primary else Color.Transparent
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = year.toString(),
                                fontSize = 18.sp,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Month selection
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
                    .border(2.dp, Color.Gray)  // 테두리 추가
                    .padding(8.dp)
            ) {
                Text("월", fontSize = 16.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(months) { month ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .clickable { selectedMonth = month }
                                .fillMaxWidth()
                                .border(
                                    1.dp,
                                    if (selectedMonth == month) MaterialTheme.colors.primary else Color.Transparent
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = month.toString(),
                                fontSize = 18.sp,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Day selection
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
                    .border(2.dp, Color.Gray)  // 테두리 추가
                    .padding(8.dp)
            ) {
                Text("일", fontSize = 16.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(days) { day ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .clickable { selectedDay = day }
                                .fillMaxWidth()
                                .border(
                                    1.dp,
                                    if (selectedDay == day) MaterialTheme.colors.primary else Color.Transparent
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = day.toString(),
                                fontSize = 18.sp,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Meal selection
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
                    .border(2.dp, Color.Gray)  // 테두리 추가
                    .padding(8.dp)
            ) {
                Text("식사", fontSize = 16.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(meals) { meal ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .clickable { selectedMeal = meal }
                                .fillMaxWidth()
                                .border(
                                    1.dp,
                                    if (selectedMeal == meal) MaterialTheme.colors.primary else Color.Transparent
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = meal,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "선택한 날짜: $selectedYear-$selectedMonth-$selectedDay $selectedMeal",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = {
                    coroutineScope.launch {
                        mypageImage.mypageSelectDate = "$selectedYear-$selectedMonth-$selectedDay"
                        mypageImage.mypageSelectTime = selectedMeal
                        get_mypageImage()

                        // 1초 딜레이
                        delay(1000L)

                        navController.navigate("mypage") {
                            popUpTo("mypage")
                        }
                    }
                },

                modifier = Modifier.size(width = 100.dp, height = 40.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text("선택", color = Color.White, fontSize = 14.sp)
            }
        }

    }
}
