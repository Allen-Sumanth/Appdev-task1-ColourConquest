package com.example.colourconquest

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    val boardItems: MutableMap<Pair<Int, Int>, ButtonData> = mutableMapOf(
        Pair(0, 0) to ButtonData.NONE,
        Pair(0, 1) to ButtonData.NONE,
        Pair(0, 2) to ButtonData.NONE,
        Pair(0, 3) to ButtonData.NONE,
        Pair(0, 4) to ButtonData.NONE,
        Pair(1, 0) to ButtonData.NONE,
        Pair(1, 1) to ButtonData.NONE,
        Pair(1, 2) to ButtonData.NONE,
        Pair(1, 3) to ButtonData.NONE,
        Pair(1, 4) to ButtonData.NONE,
        Pair(2, 0) to ButtonData.NONE,
        Pair(2, 1) to ButtonData.NONE,
        Pair(2, 2) to ButtonData.NONE,
        Pair(2, 3) to ButtonData.NONE,
        Pair(2, 4) to ButtonData.NONE,
        Pair(3, 0) to ButtonData.NONE,
        Pair(3, 1) to ButtonData.NONE,
        Pair(3, 2) to ButtonData.NONE,
        Pair(3, 3) to ButtonData.NONE,
        Pair(3, 4) to ButtonData.NONE,
        Pair(4, 0) to ButtonData.NONE,
        Pair(4, 1) to ButtonData.NONE,
        Pair(4, 2) to ButtonData.NONE,
        Pair(4, 3) to ButtonData.NONE,
        Pair(4, 4) to ButtonData.NONE,
    )
}
//PLACEHOLDER CLASS - DO NOT USE
enum class ButtonData {
    NONE
}
