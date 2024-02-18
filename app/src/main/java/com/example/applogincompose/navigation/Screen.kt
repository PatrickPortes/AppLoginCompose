package com.example.applogincompose.navigation

sealed class Screen (val route: String) {

    object SplashScreen : Screen(route = "splashScreen")
    object SignInScreen : Screen(route = "signInScreen")
    object SignUpScreen : Screen(route = "signUpScreen")
    object HomeScreen : Screen(route = "homeScreen")

}