package com.seenubommisetti.quotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.seenubommisetti.quotes.ui.screens.ExploreScreen
import com.seenubommisetti.quotes.ui.screens.HomeScreen
import com.seenubommisetti.quotes.ui.screens.SavedItemsScreen

@Composable
fun QuotesAppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppNavRoutes.Home.route
    ) {
        composable(AppNavRoutes.Home.route) {
            HomeScreen() {
                navController.navigate(AppNavRoutes.Explore.route)
            }
        }

        composable(AppNavRoutes.Explore.route) {
            ExploreScreen()
        }

        composable(AppNavRoutes.Saved.route) {
            SavedItemsScreen()
        }
    }
}