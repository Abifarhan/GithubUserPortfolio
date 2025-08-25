package com.abitask.githubuserportfolio

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abitask.githubuserportfolio.presentation.detail.UserDetailScreen
import com.abitask.githubuserportfolio.presentation.list.UserListScreen

@Composable
fun GitHubNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            UserListScreen(onClick = { login ->
                navController.navigate("detail/$login")
            })
        }
        composable("detail/{login}", arguments = listOf(navArgument("login") { type = NavType.StringType })) { backStack ->
            val login = backStack.arguments?.getString("login") ?: ""
            UserDetailScreen(login = login, onBack = { navController.popBackStack() })
        }
    }
}
