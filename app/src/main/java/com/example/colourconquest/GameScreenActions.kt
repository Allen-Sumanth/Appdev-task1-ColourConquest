package com.example.colourconquest

sealed class UserAction {
    data object Reset : UserAction()
    class ButtonClicked(val coords: Pair<Int, Int>) : UserAction()
}