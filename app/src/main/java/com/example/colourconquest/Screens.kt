package com.example.colourconquest

sealed class Screens(val route: String) {
    data object HomePage: Screens(route = "HomePage")
    data object PlayerInfo: Screens(route = "PlayerInfo")
    data object GamePage: Screens(route = "GamePage")
}