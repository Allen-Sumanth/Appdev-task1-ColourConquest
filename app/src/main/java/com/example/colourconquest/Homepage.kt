package com.example.colourconquest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.colourconquest.ui.theme.BluePlayer
import com.example.colourconquest.ui.theme.DarkBlueBackground

@Composable
fun HomePage(navController: NavController, viewModel: GameViewModel) {
    Column(
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
            .padding(top = 50.dp, start = 30.dp, end = 30.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var openGameIntro by remember { mutableStateOf(false) }
        if (openGameIntro) {
            GameIntro(onDismissRequest = { openGameIntro = false })
        }

        var openHighScores by remember { mutableStateOf(false) }
        if (openHighScores) {
            HighScores(onDismissRequest = { openHighScores = false }, viewModel = viewModel)
        }

        Text(
            text = "COLOR\nCONQUEST",
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.W900,
            fontSize = 60.sp,
            textAlign = TextAlign.Center,
            style = TextStyle(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.hsl(0F, 0.26F, 0.08F),
                        Color.hsl(4F, 0.56F, 0.68F)
                    )
                )
            )
        )

        GameIcon()

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement =Arrangement.SpaceEvenly,
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Box(
                modifier = Modifier.size(70.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        openHighScores = true
                    },
                    shape = CircleShape,
                    modifier = Modifier.fillMaxSize(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DarkBlueBackground
                    )
                ) {
                }
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "HighScores",
                    tint = Color.White,
                    modifier = Modifier
                        .scale(1.5f)
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    navController.navigate(Screens.PlayerInfo.route)
                },
                colors = ButtonDefaults.buttonColors(containerColor = BluePlayer),
                modifier = Modifier
                    .shadow(
                        elevation = 5.dp
                    )
            ) {
                Text(text = "PLAY", fontSize = 40.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    openGameIntro = true
                },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBlueBackground
                )
            ) {
                Text(text = "?", fontSize = 40.sp, color = Color.White)
            }

        }
    }
}

@Preview
@Composable
private fun Preview() {
    HomePage(navController = rememberNavController(), viewModel = GameViewModel())
}