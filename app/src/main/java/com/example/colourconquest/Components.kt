package com.example.colourconquest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
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
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()

    ) {
        Canvas(
            modifier = Modifier
                .size(400.dp)
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
                path = pathLeft,
                brush = SolidColor(DropletBackground)
            )
            drawPath(
                path = pathRight,
                brush = SolidColor(DropletBackground)
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
                modifier = Modifier
                    .offset(y = (-30).dp)
            )

        }
        Card(
            shape = AbsoluteRoundedCornerShape(100),
            colors = CardDefaults.cardColors(
                containerColor = RedPlayer
            ),
            modifier = Modifier.padding(top = 45.dp)
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
                modifier = Modifier
                    .offset(y = (-25).dp)
            )

        }
        Card(
            shape = AbsoluteRoundedCornerShape(100),
            colors = CardDefaults.cardColors(
                containerColor = BluePlayer
            ),
            modifier = Modifier.padding(top = 45.dp)
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
                    .height(500.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "ABOUT",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 5.dp),
                        color = Color.LightGray,
                        fontSize = 54.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fac" +
                                "ilisis maximus dapibus. Proin quis metus et justo sollicitudin pretiu" +
                                "msit amet vitae ipsum. Sed et feugiat sapien. Proin vel odio quis fel" +
                                "is lacinia consectetur ac vel nulla. Suspendisse tincidunt massa ips" +
                                "u nec rhoncus leo efficitur eu. Suspendisse pulvinar mi id lectus u" +
                                "lrices, nec porta massa vehicula. Maecenas laoreet volutpat est, ac " +
                                "uamcorper nunc mattis nec. Vestibulum ante ipsum primis in faucibus" +
                                "rci luctus et ultrices posuere cubilia curae; Vivamus elit urna, pu" +
                                "lnar at vulputate ac, blandit eget urnasiueeeeee.Donec porttito" +
                                "r ac odio vitae porta. Donec convallis, dui sit amet pharetra ia" +
                                "culis, nulla dolor pharetra tortor, in auctor augue lacus quis ne" +
                                "que. Duis dignissim tortor iaculis, dignissim lorem in, mattis eni" +
                                "m. Sed nec risus lacus. Suspendisse dignissim eros eu massa conval" +
                                "lis dapibus in quis tortor. Mauris vestibulum faucibus accumsan. A" +
                                "liquam lorem augue, suscipit id interdum a, vulputate vitae felis." +
                                " Duis sed orci in justo luctus lobortis vel laoreet elit. Nam mi d" +
                                "ui, vulputate vel interdum a, auctor vel mauris. Cras auctor bland" +
                                "it nisi, ornare sodales velit rutrum eu. Pellentesque habitant mor" +
                                "bi tristiqu",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                            .fillMaxWidth(),
                        color = Color.LightGray
                    )
                }
            }
        }
    }
}

@Composable
fun GameResult(modifier: Modifier = Modifier, onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(10.dp, 5.dp, 10.dp, 10.dp)
                .height(325.dp),
        ) {
            Column(
                modifier
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
                        text = "ASHWIN",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 5.dp)
                            .align(Alignment.CenterHorizontally)
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
                            color = BluePlayer, //winner color
                            start = Offset(x = 0f, y = height.times(0.3f)),
                            end = Offset(x = width.times(0.35f), y = height.times(0.3f)),
                            strokeWidth = 10f,
                            cap = StrokeCap.Round
                        )
                        drawLine(
                            color = BluePlayer, //winner color
                            start = Offset(x = width.times(0.65f), y = height.times(0.3f)),
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
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = BluePlayer),
                ) {
                    Text(text = "Play Again", fontSize = 20.sp)
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = RedPlayer),
                ) {
                    Text(text = "Home", fontSize = 20.sp)
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
        Text(text ="1", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Red2Icon(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = RedPlayer, radius = size.height.times(0.5f))
        }
        Text(text ="2", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Red3Icon(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = RedPlayer, radius = size.height.times(0.5f))
        }
        Text(text ="3", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Blue1Icon(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = BluePlayer, radius = size.height.times(0.5f))
        }
        Text(text ="1", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Blue2Icon(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = BluePlayer, radius = size.height.times(0.5f))
        }
        Text(text ="2", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Blue3Icon(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(40.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = BluePlayer, radius = size.height.times(0.5f))
        }
        Text(text ="3", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Preview(showSystemUi = false)
@Composable
private fun GamePagePreview() {
    //GamePage(navController = rememberNavController(), viewModel = GameViewModel())
    Column {
        Red1Icon()
        Red2Icon()
        Red3Icon()
        Blue1Icon()
        Blue2Icon()
        Blue3Icon()
    }
}