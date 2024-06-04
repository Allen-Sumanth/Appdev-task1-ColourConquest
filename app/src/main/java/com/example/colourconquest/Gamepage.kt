package com.example.colourconquest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.colourconquest.ui.theme.BluePlayer
import com.example.colourconquest.ui.theme.CellBackground
import com.example.colourconquest.ui.theme.DarkBlueBackground
import com.example.colourconquest.ui.theme.ExitX
import com.example.colourconquest.ui.theme.GameScreenInfoBackground
import com.example.colourconquest.ui.theme.RedPlayer

@Composable
fun GamePage(
    navController: NavController,
    viewModel: GameViewModel,
    redPlayerName: String = "Red",
    bluePlayerName: String = "Blue"
) {
    val redName = if (redPlayerName == " ") "Red" else redPlayerName
    val blueName = if (bluePlayerName == " ") "Blue" else bluePlayerName

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = viewModel.state.value.currentTurnColor)
            .padding(vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var openActonCard by remember { mutableStateOf(false) }
        if (openActonCard) {
            Dialog(onDismissRequest = { openActonCard = false }) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(10.dp, 5.dp, 10.dp, 10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .background(DarkBlueBackground)
                            //.fillMaxSize()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            //Reset
                            onClick = {
                                openActonCard = false
                                viewModel.resetGame()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = BluePlayer),
                        ) {
                            Text(text = "Reset Game", fontSize = 20.sp)
                        }
                        Button(
                            //New Game - reset game+back to PlayerInfo screen
                            onClick = {
                                openActonCard = false
                                viewModel.resetGame()
                                navController.navigate(Screens.PlayerInfo.route)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = RedPlayer),
                        ) {
                            Text(text = "New Game", fontSize = 20.sp)
                        }
                    }
                }
            }
        }  //opens exit action Dialog

        Row( //Contains Player Name, Score, and Exit Button
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Card(
                    shape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = GameScreenInfoBackground
                    ),
                    border = BorderStroke(width = 1.dp, color = Color.Black)
                ) {
                    Text(
                        text = "${viewModel.state.value.blueScore}",
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 30.dp)
                            .rotate(180F),
                        color = BluePlayer,
                        fontSize = 30.sp
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Card(
                    shape = CutCornerShape(topStartPercent = 100, bottomStartPercent = 100),
                    colors = CardDefaults.cardColors(
                        containerColor = GameScreenInfoBackground
                    ),
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                    modifier = Modifier
                        .width(200.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                ) {
                    Text(
                        text = blueName,
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 30.dp)
                            .rotate(180f),
                        color = BluePlayer,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Button(
                onClick = {
                    openActonCard = true
                },
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .size(50.dp)
            ) {
                //Icon(imageVector = Icons.Default.Close, contentDescription = "Exit")
                Text(text = "X", fontSize = 30.sp, color = ExitX, fontWeight = FontWeight.W900)
            }
        }

        LazyHorizontalGrid( //Game Board
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(ratio = 1F),
            rows = GridCells.Fixed(5),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            viewModel.boardState.forEach { (coords, data) ->
                item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1F)
                            .clickable() {
                                viewModel.updateButton(coords, primaryIteration = true)
                            }
                            .background(color = CellBackground, shape = RoundedCornerShape(15.dp))
                    ) {
                        when (viewModel.boardState[coords]) {
                            is ButtonData.Red1 -> {
                                Red1Icon()
                            }

                            is ButtonData.Red2 -> {
                                Red2Icon()
                            }

                            is ButtonData.Red3 -> {
                                Red3Icon()
                            }

                            is ButtonData.Blue1 -> {
                                Blue1Icon()
                            }

                            is ButtonData.Blue2 -> {
                                Blue2Icon()
                            }

                            is ButtonData.Blue3 -> {
                                Blue3Icon()
                            }
                        }
                    }
                }
            }
        }

        Row(
            //Contains Player Name, Score
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Row {
                Card(
                    shape = CutCornerShape(topEndPercent = 100, bottomEndPercent = 100),
                    colors = CardDefaults.cardColors(
                        containerColor = GameScreenInfoBackground
                    ),
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                    modifier = Modifier
                        .width(200.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                ) {
                    Text(
                        text = redName,
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 30.dp),
                        color = RedPlayer,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.width(5.dp))

                Card(
                    shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = GameScreenInfoBackground
                    ),
                    border = BorderStroke(width = 1.dp, color = Color.Black)
                ) {
                    Text(
                        text = "${viewModel.state.value.redScore}",
                        modifier = Modifier.padding(vertical = 5.dp, horizontal = 30.dp),
                        color = RedPlayer,
                        fontSize = 30.sp
                    )
                }

            }
        }

        var openResultCard = viewModel.checkForWin()
        if (openResultCard) {
            val winName = if (viewModel.state.value.currentTurnColor == BluePlayer) redName else blueName
            viewModel.highScores[winName] = if (
                viewModel.state.value.currentTurnColor == BluePlayer &&
                viewModel.state.value.redScore >= viewModel.highScores.getOrDefault(winName, 0)
            ) {
                viewModel.state.value.redScore
            } else if (
                viewModel.state.value.currentTurnColor == RedPlayer &&
                viewModel.state.value.blueScore >= viewModel.highScores.getOrDefault(winName, 0)
                ) {
                viewModel.state.value.blueScore
            } else 0

            Dialog(onDismissRequest = { openResultCard = false }) {
                Card(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .padding(10.dp, 5.dp, 10.dp, 10.dp)
                        .height(325.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .background(DarkBlueBackground)
                            .fillMaxSize()
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Card(
                            shape = RoundedCornerShape(percent = 100),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                        ) {
                            Text(
                                text = winName,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(vertical = 5.dp)
                                    .align(Alignment.CenterHorizontally),
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 0.dp)
                                .fillMaxWidth()
                        ) {
                            Canvas(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        color = DarkBlueBackground,
                                        shape = RoundedCornerShape(30.dp)
                                    )
                            ) {
                                val height = size.height
                                val width = size.width

                                drawLine(
                                    color = if (viewModel.state.value.currentTurnColor == BluePlayer) RedPlayer else BluePlayer, //winner color
                                    start = Offset(x = 0f, y = height.times(0.3f)),
                                    end = Offset(
                                        x = width.times(0.35f),
                                        y = height.times(0.3f)
                                    ),
                                    strokeWidth = 10f,
                                    cap = StrokeCap.Round
                                )
                                drawLine(
                                    color = if (viewModel.state.value.currentTurnColor == BluePlayer) RedPlayer else BluePlayer, //winner color
                                    start = Offset(
                                        x = width.times(0.65f),
                                        y = height.times(0.3f)
                                    ),
                                    end = Offset(x = width, y = height.times(0.3f)),
                                    strokeWidth = 10f,
                                    cap = StrokeCap.Round
                                )
                            }

                            Image(
                                painter = painterResource(id = R.drawable.medal_icon),
                                contentDescription = "Medal",
                                modifier = Modifier.size(100.dp),
                            )
                        }
                        Text(
                            text = "WINS!",
                            fontSize = 30.sp,
                            color = Color.White,
                        )
                        //PLAY AGAIN BUTTON--------------------------------------------------------------
                        Button(
                            onClick = {
                                openActonCard = false
                                viewModel.resetGame()
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = BluePlayer),
                        ) {
                            Text(text = "Play Again", fontSize = 20.sp)
                        }
                        //HOME BUTTON--------------------------------------------------------------------
                        Button(
                            onClick = {
                                openActonCard = false
                                viewModel.resetGame()
                                navController.navigate(Screens.HomePage.route)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = RedPlayer),
                        ) {
                            Text(text = "Home", fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun GamePagePreview() {
    GamePage(navController = rememberNavController(), viewModel = GameViewModel(), "Red", "Blue")
}