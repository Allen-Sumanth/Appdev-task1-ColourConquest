package com.example.colourconquest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.colourconquest.ui.theme.BluePlayer
import com.example.colourconquest.ui.theme.DropletBackground
import com.example.colourconquest.ui.theme.DarkBlueBackground
import com.example.colourconquest.ui.theme.RedPlayer

const val CARDHEIGHT = 125

@Composable
fun PlayerSymbolRed(modifier: Modifier = Modifier) { //Player red logo
    Icon(imageVector = Icons.Default.Person, contentDescription = "Player Icon", tint = RedPlayer)
}

@Composable
fun PlayerSymbolBlue(modifier: Modifier = Modifier) { //Player blue logo
    Icon(imageVector = Icons.Default.Person, contentDescription = "Player Icon", tint = BluePlayer)
}

@Composable
fun GameIcon(modifier: Modifier = Modifier) {//Vector in the middle of the screen
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()

    ) {
        Canvas(
            modifier = Modifier.size(400.dp)
        ) {
            val width = size.width
            val height = size.height

            /* Bezier cubics coords obtained from Figma design */
            val pathLeft = Path().apply {
                moveTo(x = width.times(0.47f), y = height.times(0.5f))
                cubicTo(
                    x1 = width.times(0.4426f),
                    y1 = height.times(0.4817f),
                    x2 = width.times(0.2391f),
                    y2 = height.times(0.41f),
                    x3 = width.times(0.1647f),
                    y3 = height.times(0.41f)
                )
                cubicTo(
                    x1 = width.times(0.0903f),
                    y1 = height.times(0.41f),
                    x2 = width.times(0.03f),
                    y2 = height.times(0.4503f),
                    x3 = width.times(0.03f),
                    y3 = height.times(0.5f)
                )
                cubicTo(
                    x1 = width.times(0.03f),
                    y1 = height.times(0.5497f),
                    x2 = width.times(0.0903f),
                    y2 = height.times(0.59f),
                    x3 = width.times(0.1647f),
                    y3 = height.times(0.59f)
                )
                cubicTo(
                    x1 = width.times(0.2391f),
                    y1 = height.times(0.59f),
                    x2 = width.times(0.4426f),
                    y2 = height.times(0.5183f),
                    x3 = width.times(0.47f),
                    y3 = height.times(0.5f)
                )
                close()
            }
            val pathRight = Path().apply {
                moveTo(x = width.times(0.53f), y = height.times(0.5f))
                cubicTo(
                    x1 = width.times(0.5574f),
                    y1 = height.times(0.4817f),
                    x2 = width.times(0.7609f),
                    y2 = height.times(0.41f),
                    x3 = width.times(0.8353f),
                    y3 = height.times(0.41f)
                )
                cubicTo(
                    x1 = width.times(0.9097f),
                    y1 = height.times(0.41f),
                    x2 = width.times(0.97f),
                    y2 = height.times(0.4503f),
                    x3 = width.times(0.97f),
                    y3 = height.times(0.5f)
                )
                cubicTo(
                    x1 = width.times(0.97f),
                    y1 = height.times(0.5497f),
                    x2 = width.times(0.9097f),
                    y2 = height.times(0.59f),
                    x3 = width.times(0.8353f),
                    y3 = height.times(0.59f)
                )
                cubicTo(
                    x1 = width.times(0.7609f),
                    y1 = height.times(0.59f),
                    x2 = width.times(0.5574f),
                    y2 = height.times(0.5183f),
                    x3 = width.times(0.53f),
                    y3 = height.times(0.5f)
                )
                close()
            }

            drawPath(
                path = pathLeft, brush = SolidColor(DropletBackground)
            )
            drawPath(
                path = pathRight, brush = SolidColor(DropletBackground)
            )

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Player Icon",
                tint = RedPlayer,
                modifier = Modifier
                    .size(150.dp)
                    .padding(bottom = 50.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Player Icon",
                tint = BluePlayer,
                modifier = Modifier
                    .size(150.dp)
                    .padding(bottom = 50.dp)
            )
        }
    }
}

@Composable
fun Player1Card() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(10.dp)
            .size(200.dp, height = CARDHEIGHT.dp)
    ) {
        Canvas(
            modifier = Modifier
                .size(200.dp, 100.dp)
                .background(color = DarkBlueBackground, shape = RoundedCornerShape(30.dp))
        ) {
            val height = size.height
            val width = size.width

            drawLine(
                color = RedPlayer,
                start = Offset(x = width.times(0.04f), y = height.times(0.3f)),
                end = Offset(x = width.times(0.35f), y = height.times(0.3f)),
                strokeWidth = 5f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = RedPlayer,
                start = Offset(x = width.times(0.65f), y = height.times(0.3f)),
                end = Offset(x = width.times(0.96f), y = height.times(0.3f)),
                strokeWidth = 5f,
                cap = StrokeCap.Round
            )
        }
        Box {
            Text(
                text = "1",
                color = DarkBlueBackground,
                fontSize = 90.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(y = (-40).dp)
            )
            Text(
                text = "1",
                color = RedPlayer,
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(y = (-30).dp)
            )

        }
        Card(
            shape = AbsoluteRoundedCornerShape(100), colors = CardDefaults.cardColors(
                containerColor = RedPlayer
            ), modifier = Modifier.padding(top = 45.dp)
        ) {
            Text(
                "PLAYER",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.White,
                    textDecoration = TextDecoration.Underline,
                ),
                modifier = Modifier.width(180.dp)
            )
        }
    }

    //Image(painter = painterResource(id = R.drawable.player1card), contentDescription = "player 1 card")
}

@Composable
fun Player2Card() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(10.dp)
            .size(200.dp, height = CARDHEIGHT.dp)
    ) {
        Canvas(
            modifier = Modifier
                .size(200.dp, 100.dp)
                .background(color = DarkBlueBackground, shape = RoundedCornerShape(30.dp))
        ) {
            val height = size.height
            val width = size.width

            drawLine(
                color = BluePlayer,
                start = Offset(x = width.times(0.04f), y = height.times(0.3f)),
                end = Offset(x = width.times(0.35f), y = height.times(0.3f)),
                strokeWidth = 5f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = BluePlayer,
                start = Offset(x = width.times(0.65f), y = height.times(0.3f)),
                end = Offset(x = width.times(0.96f), y = height.times(0.3f)),
                strokeWidth = 5f,
                cap = StrokeCap.Round
            )
        }
        Box {
            Text(
                text = "2",
                color = DarkBlueBackground,
                fontSize = 90.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(x = (-3).dp, y = (-35).dp)
            )
            Text(
                text = "2",
                color = BluePlayer,
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(y = (-25).dp)
            )

        }
        Card(
            shape = AbsoluteRoundedCornerShape(100), colors = CardDefaults.cardColors(
                containerColor = BluePlayer
            ), modifier = Modifier.padding(top = 45.dp)
        ) {
            Text(
                "PLAYER",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.White,
                    textDecoration = TextDecoration.Underline,
                ),
                modifier = Modifier.width(180.dp)
            )
        }
    }

    //Image(painter = painterResource(id = R.drawable.player1card), contentDescription = "player 1 card")
}

@Composable
fun GameIntro(modifier: Modifier = Modifier, onDismissRequest: () -> Unit) {
    val textData = listOf(
        "1st Turn of each player: Players can choose any tile on the grid on this turn only. Clicking a tile assigns your colour to it and awards you 3 points on that tile.\n\n",
        "Subsequent Turns: After the first turn, players can only click on tiles that already have their own colour. Clicking a tile with your colour adds 1 point to that tile.The background colour indicates the next player.\n\n",
        "Conquest and Expansion: When a tile with your colour reaches 4 points, it triggers an expansion\n\n",
        "The colour completely disappears from the original tile.\n\n",
        "Your colour spreads to the four surrounding squares in a plus shape (up, down, left, right).\n\n",
        "Each of the four surrounding squares gains 1 point with your colour.\n\n",
        "If any of the four has your opponent’s colour, you conquer the opponent's points on that tile while adding a point to it, completely erasing theirs.\n\n",
        "The expansion is retriggered if the neighbouring tile as well reaches 4 points this way.\n\n",
        "Players take turns clicking on tiles and the objective is to eliminate your opponent's colour entirely from the screen.\n\n"
    )
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(10.dp, 5.dp, 10.dp, 10.dp)
                .height(500.dp),
            border = BorderStroke(width = 3.dp, color = Color.LightGray),

            ) {
            Column(
                modifier
                    .background(DarkBlueBackground)
                    .height(500.dp)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ABOUT",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp),
                    color = Color.LightGray,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(buildAnnotatedString {
                    textData.forEach {
                        withStyle(style = SpanStyle(color = Color.LightGray)) {
                            append("-")
                            append("\t\t")
                            append(it)
                        }
                    }
                })
            }
        }
    }
}

@Composable
fun HighScores(
    modifier: Modifier = Modifier, onDismissRequest: () -> Unit, viewModel: GameViewModel
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(10.dp, 5.dp, 10.dp, 10.dp)
                .size(300.dp, 500.dp)
                .background(DarkBlueBackground),
            border = BorderStroke(width = 3.dp, color = Color.LightGray),

            ) {
            LazyColumn(
                modifier = Modifier
                    .background(DarkBlueBackground)
                    .size(300.dp, 500.dp)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(10.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "HIGH",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                            color = Color.LightGray,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "SCORES",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 10.dp),
                            color = Color.LightGray,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                viewModel.highScores.forEach { (name, score) ->
                    item {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp)
                        ) {
                            Text(
                                text = name,
                                color = Color.LightGray,
                                fontSize = 20.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.width(150.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = score.toString(), color = Color.LightGray, fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Red1Icon(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = RedPlayer, radius = size.height.times(0.5f))
        }
        Text(text = "1", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Red2Icon(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = RedPlayer, radius = size.height.times(0.5f))
        }
        Text(text = "2", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Red3Icon(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = RedPlayer, radius = size.height.times(0.5f))
        }
        Text(text = "3", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Blue1Icon(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = BluePlayer, radius = size.height.times(0.5f))
        }
        Text(text = "1", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Blue2Icon(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = BluePlayer, radius = size.height.times(0.5f))
        }
        Text(text = "2", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Blue3Icon(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = BluePlayer, radius = size.height.times(0.5f))
        }
        Text(text = "3", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Preview(showSystemUi = false)
@Composable
private fun GamePagePreview() {
    HomePage(navController = rememberNavController(), viewModel = GameViewModel())
}