package com.example.colourconquest

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel: GameViewModel = viewModel<GameViewModel>()

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
        composable(
            route = Screens.GamePage.route + "/{redName}" + "/{blueName}",
            arguments = listOf(
                navArgument("redName") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = "Red"
                },
                navArgument("blueName") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = "Blue"
                }
            )
        ) { entry ->
            GamePage(
                navController = navController,
                viewModel = viewModel,
                redPlayerName = entry.arguments?.getString("redName").toString(),
                bluePlayerName = entry.arguments?.getString("blueName").toString()
            )
        }
    }
}


@Preview
@Composable
private fun Preview() {
    PlayerInfo(navController = rememberNavController())
}