package com.example.colourconquest

import androidx.compose.ui.graphics.Color
import com.example.colourconquest.ui.theme.RedPlayer

data class GameState(
    val redScore: Int = 0,
    val blueScore: Int = 0,
    val currentTurnColor: Color = RedPlayer,
    val hasWon: Boolean = false
)


open class ButtonData(color: PlayerColor, value: Int) {
    object None : ButtonData(PlayerColor.NONE, 0)
    object Red1 : ButtonData(PlayerColor.RED, 1)
    object Red2 : ButtonData(PlayerColor.RED, 2)
    object Red3 : ButtonData(PlayerColor.RED, 3)
    object Blue1 : ButtonData(PlayerColor.BLUE, 1)
    object Blue2 : ButtonData(PlayerColor.BLUE, 2)
    object Blue3 : ButtonData(PlayerColor.BLUE, 3)
}

enum class PlayerColor {
    NONE,
    RED,
    BLUE
}