package com.example.colourconquest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.colourconquest.ui.theme.BluePlayer
import com.example.colourconquest.ui.theme.DarkBlueBackground
import com.example.colourconquest.ui.theme.ExitX
import com.example.colourconquest.ui.theme.PlayerInfoBackground
import com.example.colourconquest.ui.theme.RedPlayer

@Composable
fun PlayerInfo(navController: NavController) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.hsl(34F, 1F, 0.72F),
                        Color.hsl(355F, 1F, 0.69F)
                    )
                )
            )
            .padding(vertical = 20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp)
        ) {
            Card(
                shape = AbsoluteCutCornerShape(percent = 100),
                colors = CardDefaults.cardColors(
                    containerColor = PlayerInfoBackground
                ),
                border = BorderStroke(width = 1.dp, color = ExitX)
            ) {
                Text(
                    text = "PLAYER INFORMATION",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 10.dp)
                )
            }
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Player1Card()
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(10.dp, 25.dp)
                            .size(200.dp, 100.dp)
                            .background(
                                color = DarkBlueBackground,
                                shape = RoundedCornerShape(30.dp)
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Player Icon",
                            tint = RedPlayer,
                            modifier = Modifier
                                .size(60.dp)
                        )
                        TextField(
                            value = "",
                            onValueChange = {
                                TODO()
                            },
                            label = {
                                Text(
                                    text = " Enter Player-1 Name",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                unfocusedLabelColor = Color.Gray,
                                focusedLabelColor = Color.Gray,
                                focusedTextColor = Color.White,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .height(25.dp)
                                .drawBehind {
                                    drawLine(
                                        color = RedPlayer,
                                        start = Offset(size.width.times(0.1f), size.height),
                                        end = Offset(size.width.times(0.9f), size.height),
                                        strokeWidth = 6f,
                                        cap = StrokeCap.Round,
                                        pathEffect = PathEffect.dashPathEffect(
                                            intervals = floatArrayOf(20f, 20f)
                                        )
                                    )
                                }
                        )

                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Player2Card()
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(10.dp, 25.dp)
                            .size(200.dp, 100.dp)
                            .background(
                                color = DarkBlueBackground,
                                shape = RoundedCornerShape(30.dp)
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Player Icon",
                            tint = BluePlayer,
                            modifier = Modifier
                                .size(60.dp)
                        )
                        TextField(
                            value = "",
                            onValueChange = {
                                TODO()
                            },
                            label = {
                                Text(
                                    text = " Enter Player-2 Name",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                unfocusedLabelColor = Color.Gray,
                                focusedLabelColor = Color.Gray,
                                focusedTextColor = Color.White,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .height(25.dp)
                                .drawBehind {
                                    drawLine(
                                        color = BluePlayer,
                                        start = Offset(size.width.times(0.1f), size.height),
                                        end = Offset(size.width.times(0.9f), size.height),
                                        strokeWidth = 6f,
                                        cap = StrokeCap.Round,
                                        pathEffect = PathEffect.dashPathEffect(
                                            intervals = floatArrayOf(20f, 20f)
                                        )
                                    )
                                }
                        )

                    }
                }
            }
            Spacer(modifier = Modifier.height(100.dp))
            Button(
                onClick = {
                    navController.navigate(Screens.GamePage.route)
                },
                colors = ButtonDefaults.buttonColors(containerColor = BluePlayer),
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "START",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

        }
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            GameIcon()
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PlayerInfo(navController = rememberNavController())
}