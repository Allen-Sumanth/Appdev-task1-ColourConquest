package com.example.colourconquest

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
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
import androidx.compose.ui.graphics.Color
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
    val redName = if(redPlayerName == " ") "Red" else redPlayerName
    val blueName = if(bluePlayerName == " ") "Blue" else bluePlayerName

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
                    //.height(325.dp),
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
                                viewModel.gameScreenAction(UserAction.Reset)
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
                                viewModel.gameScreenAction(UserAction.Reset)
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

        LazyVerticalGrid( //Game Board
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(ratio = 1F),
            columns = GridCells.Fixed(5),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            viewModel.boardItems.forEach { (coords, data) ->
                item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1F)
                            .clickable() {
                                viewModel.gameScreenAction(UserAction.ButtonClicked(coords))
                            }
                            .background(color = CellBackground, shape = RoundedCornerShape(15.dp))
                    ) {
                        when (data) {
                            ButtonData.Red1 -> {
                                Red1Icon()
                            }

                            ButtonData.Red2 -> {
                                Red2Icon()
                            }

                            ButtonData.Red3 -> {
                                Red3Icon()
                            }

                            ButtonData.Blue1 -> {
                                Blue1Icon()
                            }

                            ButtonData.Blue2 -> {
                                Blue2Icon()
                            }

                            ButtonData.Blue3 -> {
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

        var openResultCard by remember { mutableStateOf(false) }
        if (openResultCard) {
            GameResult(onDismissRequest = { openResultCard = false })
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun GamePagePreview() {
    GamePage(navController = rememberNavController(), viewModel = GameViewModel(), "Red", "Blue")
}