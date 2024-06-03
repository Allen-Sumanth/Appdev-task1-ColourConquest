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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.colourconquest.ui.theme.BluePlayer
import com.example.colourconquest.ui.theme.CellBackground
import com.example.colourconquest.ui.theme.ExitX
import com.example.colourconquest.ui.theme.GameScreenInfoBackground
import com.example.colourconquest.ui.theme.RedPlayer

@Composable
fun GamePage(
    navController: NavController,
    viewModel: GameViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BluePlayer)
            .padding(vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
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
                        text = "7",
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
                        text = "ASHWIN",
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
                    navController.navigate(Screens.HomePage.route)
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

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(ratio = 1F),
            columns = GridCells.Fixed(5),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            viewModel.boardItems.forEach {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1F)
                            .clickable { TODO() }
                            .background(color = CellBackground, shape = RoundedCornerShape(15.dp))
                    ) {

                    }
                }
            }
        }

        Row(
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
                        text = "ANSH",
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
                        text = "7",
                        modifier = Modifier.padding(vertical = 5.dp, horizontal = 30.dp),
                        color = RedPlayer,
                        fontSize = 30.sp
                    )
                }

            }
        }

        var openResultCard by remember { mutableStateOf(false) }
        if(openResultCard) {
            GameResult(onDismissRequest = {openResultCard = false})
        }
    }
}

@Preview
@Composable
private fun GamePagePreview() {
    GamePage(navController = rememberNavController(), viewModel = GameViewModel())
}