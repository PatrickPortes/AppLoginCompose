package com.example.applogincompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applogincompose.compose.AnimatedSplashScreen
import com.example.applogincompose.compose.HomeScreen
import com.example.applogincompose.compose.SignInScreen
import com.example.applogincompose.compose.SignUpScreen

@Composable
fun Navigation() {

    //NavGraph:
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {

        composable(Screen.SplashScreen.route) {
            AnimatedSplashScreen(navController)
        }
        composable(Screen.SignInScreen.route) {
            SignInScreen(navController)
        }
        composable(Screen.SignUpScreen.route) {
            SignUpScreen(navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen()
        }

    }
}