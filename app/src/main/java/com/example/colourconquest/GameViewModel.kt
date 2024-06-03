package com.example.colourconquest

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.colourconquest.ui.theme.BluePlayer
import com.example.colourconquest.ui.theme.RedPlayer

class GameViewModel : ViewModel() {
    var state = mutableStateOf(GameState())

    val boardItems: MutableMap<Pair<Int, Int>, ButtonData> = mutableMapOf(
        Pair(0, 0) to ButtonData.None,
        Pair(0, 1) to ButtonData.None,
        Pair(0, 2) to ButtonData.None,
        Pair(0, 3) to ButtonData.None,
        Pair(0, 4) to ButtonData.None,
        Pair(1, 0) to ButtonData.None,
        Pair(1, 1) to ButtonData.None,
        Pair(1, 2) to ButtonData.None,
        Pair(1, 3) to ButtonData.None,
        Pair(1, 4) to ButtonData.None,
        Pair(2, 0) to ButtonData.None,
        Pair(2, 1) to ButtonData.None,
        Pair(2, 2) to ButtonData.None,
        Pair(2, 3) to ButtonData.None,
        Pair(2, 4) to ButtonData.None,
        Pair(3, 0) to ButtonData.None,
        Pair(3, 1) to ButtonData.None,
        Pair(3, 2) to ButtonData.None,
        Pair(3, 3) to ButtonData.None,
        Pair(3, 4) to ButtonData.None,
        Pair(4, 0) to ButtonData.None,
        Pair(4, 1) to ButtonData.None,
        Pair(4, 2) to ButtonData.None,
        Pair(4, 3) to ButtonData.None,
        Pair(4, 4) to ButtonData.None,
    )
    fun gameScreenAction(action: UserAction) {
        when (action) {
            is UserAction.Reset -> {
                resetGame()
            }

            is UserAction.ButtonClicked -> {
                if (boardItems[action.coords] == ButtonData.None) {
                    updateButton(action.coords)
                }
            }
        }
    }

    private fun updateButton(coords: Pair<Int, Int>) {
        val (xCoord, yCoord) = coords
        if (state.value.currentTurnColor == RedPlayer) {
            if (boardItems[coords] == ButtonData.None) {
                boardItems[coords] = ButtonData.Red1
                state.value = state.value.copy(
                    redScore = state.value.redScore + 1,
                    currentTurnColor = BluePlayer,
                )
            }
            else if (boardItems[coords] == ButtonData.Red1 || boardItems[coords] == ButtonData.Blue1) {
                boardItems[coords] = ButtonData.Red2
                state.value = state.value.copy(
                    redScore = state.value.redScore + 1,
                    currentTurnColor = BluePlayer,
                )
            } else if (boardItems[coords] == ButtonData.Red2 || boardItems[coords] == ButtonData.Blue2) {
                boardItems[coords] = ButtonData.Red3
                state.value = state.value.copy(
                    redScore = state.value.redScore + 1,
                    currentTurnColor = BluePlayer,
                )
            } else if (boardItems[coords] == ButtonData.Red3 || boardItems[coords] == ButtonData.Blue3) {
                boardItems[coords] = ButtonData.None
                state.value = state.value.copy(
                    redScore = state.value.redScore - 3,
                    currentTurnColor = BluePlayer,
                )
//                if (xCoord < 4) updateButton(Pair(xCoord + 1, yCoord))
//                if (yCoord < 4) updateButton(Pair(xCoord, yCoord + 1))
//                if (xCoord > 0) updateButton(Pair(xCoord - 1, yCoord))
//                if (yCoord > 0) updateButton(Pair(xCoord, yCoord - 1))
            }
        } else if (state.value.currentTurnColor == BluePlayer) {
            if (boardItems[coords] == ButtonData.None){
                boardItems[coords] = ButtonData.Blue1
                state.value = state.value.copy(
                    blueScore = state.value.blueScore + 1,
                    currentTurnColor = RedPlayer,
                )
            }
            else if (boardItems[coords] == ButtonData.Blue1 || boardItems[coords] == ButtonData.Red1) {
                boardItems[coords] = ButtonData.Blue2
                state.value = state.value.copy(
                    blueScore = state.value.blueScore + 1,
                    currentTurnColor = RedPlayer,
                )
            } else if (boardItems[coords] == ButtonData.Blue2 || boardItems[coords] == ButtonData.Red2) {
                boardItems[coords] = ButtonData.Blue3
                state.value = state.value.copy(
                    blueScore = state.value.blueScore + 1,
                    currentTurnColor = RedPlayer,
                )
            } else if (boardItems[coords] == ButtonData.Blue3 || boardItems[coords] == ButtonData.Red3) {
                boardItems[coords] = ButtonData.None
                state.value = state.value.copy(
                    blueScore = state.value.blueScore - 3,
                    currentTurnColor = RedPlayer,
                )
//                if (xCoord < 4) updateButton(Pair(xCoord + 1, yCoord))
//                if (yCoord < 4) updateButton(Pair(xCoord, yCoord + 1))
//                if (xCoord > 0) updateButton(Pair(xCoord - 1, yCoord))
//                if (yCoord > 0) updateButton(Pair(xCoord, yCoord - 1))
            }
        }
    }

    private fun resetGame() { //change all board values to 0, reset scores, and close the dialog
        boardItems.forEach { (coords, data) ->
            boardItems[coords] = ButtonData.None
            state.value = state.value.copy(
                redScore = 0,
                blueScore = 0,
                currentTurnColor = RedPlayer
            )
        }
    }

}
