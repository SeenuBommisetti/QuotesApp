package com.seenubommisetti.quotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.seenubommisetti.quotes.ui.QuotesViewModel
import com.seenubommisetti.quotes.ui.screens.ExploreScreen
import com.seenubommisetti.quotes.ui.screens.HomeScreen
import com.seenubommisetti.quotes.ui.screens.SavedItemsScreen

@Composable
fun QuotesAppNavigation(
    navController: NavHostController,
    viewModel: QuotesViewModel,
    modifier: Modifier = Modifier
) {




    NavHost(
        navController = navController,
        startDestination = AppNavRoutes.Home.route
    ) {
        composable(AppNavRoutes.Home.route) {
            HomeScreen(
                viewModel = viewModel,
                onNavigateToExplore = { navController.navigate(AppNavRoutes.Explore.route) },
                onNavigateToCategory = { category ->
                    navController.navigate("details/$category")
                },
                 modifier = modifier
            )
        }

        composable(AppNavRoutes.Explore.route) {
            ExploreScreen(
                viewModel = viewModel,
                modifier = modifier
            )
        }

        composable(
            route = AppNavRoutes.Details.route,
            arguments = listOf(
                navArgument("category") { type = NavType.StringType }
            )
        ) { backStackEntry ->

            val categoryName = backStackEntry.arguments?.getString("category")

            ExploreScreen(viewModel = viewModel, category = categoryName, modifier = modifier)
        }

        composable(AppNavRoutes.Saved.route) {
            SavedItemsScreen(viewModel = viewModel, modifier = modifier)
        }
    }
}