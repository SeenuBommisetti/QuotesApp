package com.seenubommisetti.quotes.navigation

sealed class AppNavRoutes(val route: String) {
    object Home : AppNavRoutes("home")
    object Explore: AppNavRoutes("explore")

    object Details: AppNavRoutes("details/{category}")
    object Saved: AppNavRoutes("saved")
}