package com.example.colourconquest

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.colourconquest.ui.theme.BluePlayer
import com.example.colourconquest.ui.theme.RedPlayer
import kotlin.system.exitProcess

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

    var boardState by mutableStateOf(boardItems)

    var highScores: MutableMap<String, Int> = mutableMapOf()

    fun updateButton(coords: Pair<Int, Int>, primaryIteration: Boolean) {
        val (xCoord, yCoord) = coords
        var actionDone = false

        if (state.value.currentTurnColor == RedPlayer) {
            if (boardState[coords] == ButtonData.None) {
                boardState[coords] = ButtonData.Red1
                state.value = state.value.copy(
                    redScore = state.value.redScore + 1
                )
                actionDone = true
            }
            else if (boardState[coords] == ButtonData.Red1) {
                boardState[coords] = ButtonData.Red2
                state.value = state.value.copy(
                    redScore = state.value.redScore + 1
                )
                actionDone = true
            }
            else if (boardState[coords] == ButtonData.Red2) {
                boardState[coords] = ButtonData.Red3
                state.value = state.value.copy(
                    redScore = state.value.redScore + 1
                )
                actionDone = true
            }
            else if (boardState[coords] == ButtonData.Red3) {
                boardState[coords] = ButtonData.None
                state.value = state.value.copy(
                    redScore = state.value.redScore - 3
                )
                actionDone = true
                if (xCoord < 4) updateButton(Pair(xCoord + 1, yCoord), false)
                if (yCoord < 4) updateButton(Pair(xCoord, yCoord + 1), false)
                if (xCoord > 0) updateButton(Pair(xCoord - 1, yCoord), false)
                if (yCoord > 0) updateButton(Pair(xCoord, yCoord - 1), false)
            }
            else if (boardState[coords] == ButtonData.Blue1 && !primaryIteration) {
                boardState[coords] = ButtonData.Red2
                state.value = state.value.copy(
                    redScore = state.value.redScore + 2,
                    blueScore = state.value.blueScore - 1
                )
                actionDone = true
            }
            else if (boardState[coords] == ButtonData.Blue2 && !primaryIteration) {
                boardState[coords] = ButtonData.Red3
                state.value = state.value.copy(
                    redScore = state.value.redScore + 3,
                    blueScore = state.value.blueScore - 2,
                )
                actionDone = true
            }
            else if (boardState[coords] == ButtonData.Blue3 && !primaryIteration) {
                boardState[coords] = ButtonData.None
                state.value = state.value.copy(
                    blueScore = state.value.blueScore - 3,
                )
                actionDone = true
                if (xCoord < 4) updateButton(Pair(xCoord + 1, yCoord), primaryIteration = false)
                if (yCoord < 4) updateButton(Pair(xCoord, yCoord + 1), primaryIteration = false)
                if (xCoord > 0) updateButton(Pair(xCoord - 1, yCoord), primaryIteration = false)
                if (yCoord > 0) updateButton(Pair(xCoord, yCoord - 1), primaryIteration = false)
            }

            if (actionDone) {
                state.value = state.value.copy(
                        currentTurnColor = if (!primaryIteration) RedPlayer else BluePlayer,
                    )
            }
        }
        else if (state.value.currentTurnColor == BluePlayer) {
            if (boardState[coords] == ButtonData.None){
                boardState[coords] = ButtonData.Blue1
                state.value = state.value.copy(
                    blueScore = state.value.blueScore + 1,
                    currentTurnColor = if (!primaryIteration) BluePlayer else RedPlayer,
                )
                actionDone = true
            }
            else if (boardState[coords] == ButtonData.Blue1) {
                boardState[coords] = ButtonData.Blue2
                state.value = state.value.copy(
                    blueScore = state.value.blueScore + 1
                )
                actionDone = true
            }
            else if (boardState[coords] == ButtonData.Blue2) {
                boardState[coords] = ButtonData.Blue3
                state.value = state.value.copy(
                    blueScore = state.value.blueScore + 1
                )
                actionDone = true
            }
            else if (boardState[coords] == ButtonData.Blue3) {
                boardState[coords] = ButtonData.None
                state.value = state.value.copy(
                    blueScore = state.value.blueScore - 3,
                )
                actionDone = true
                if (xCoord < 4) updateButton(Pair(xCoord + 1, yCoord), primaryIteration = false)
                if (yCoord < 4) updateButton(Pair(xCoord, yCoord + 1), primaryIteration = false)
                if (xCoord > 0) updateButton(Pair(xCoord - 1, yCoord), primaryIteration = false)
                if (yCoord > 0) updateButton(Pair(xCoord, yCoord - 1), primaryIteration = false)
            }
            else if (boardState[coords] == ButtonData.Red1 && !primaryIteration) {
                boardState[coords] = ButtonData.Blue2
                state.value = state.value.copy(
                    redScore = state.value.redScore - 1,
                    blueScore = state.value.blueScore + 2,
                )
                actionDone = true
            }
            else if (boardState[coords] == ButtonData.Red2 && !primaryIteration) {
                boardState[coords] = ButtonData.Blue3
                state.value = state.value.copy(
                    redScore = state.value.redScore - 2,
                    blueScore = state.value.blueScore + 3,
                )
                actionDone = true
            }
            else if (boardState[coords] == ButtonData.Red3 && !primaryIteration) {
                boardState[coords] = ButtonData.None
                state.value = state.value.copy(
                    redScore = state.value.redScore - 3,
                )
                actionDone = true
                if (xCoord < 4) updateButton(Pair(xCoord + 1, yCoord), primaryIteration = false)
                if (yCoord < 4) updateButton(Pair(xCoord, yCoord + 1), primaryIteration = false)
                if (xCoord > 0) updateButton(Pair(xCoord - 1, yCoord), primaryIteration = false)
                if (yCoord > 0) updateButton(Pair(xCoord, yCoord - 1), primaryIteration = false)
            }

            if (actionDone) {
                state.value = state.value.copy(
                    currentTurnColor = if (!primaryIteration) BluePlayer else RedPlayer,
                )
            }
        }

        checkForWin()
        if (state.value.hasWon) return
    }

    fun checkForWin(): Boolean {
        if((state.value.redScore == 0 && state.value.blueScore > 1) || (state.value.blueScore == 0 && state.value.redScore > 1)) {
            state.value = state.value.copy(
                hasWon = true,
            )
            return true
        } else return false
    }

    fun resetGame() { //change all board values to 0, reset scores, and close the dialog
        boardState.forEach { (coords, data) ->
            boardState[coords] = ButtonData.None
            state.value = state.value.copy(
                redScore = 0,
                blueScore = 0,
                currentTurnColor = RedPlayer,
                hasWon = false
            )
        }
    }


}
