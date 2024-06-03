package com.example.colourconquest

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.HomePage.route) {
        //Describing home screen
        composable(route = Screens.HomePage.route) {
            HomePage(navController = navController)
        }
        //Describing Player initialization screen
        composable(route = Screens.PlayerInfo.route) {
            PlayerInfo(navController = navController)
        }
        //Describing Gameplay screen
        composable(route = Screens.GamePage.route) {
            GamePage(navController = navController, viewModel = GameViewModel())
        }
    }
}


@Preview
@Composable
private fun Preview() {
    PlayerInfo(navController = rememberNavController())
}