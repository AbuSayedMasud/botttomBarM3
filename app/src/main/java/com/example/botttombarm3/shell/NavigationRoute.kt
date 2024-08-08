package com.example.botttombarm3.shell

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.botttombarm3.BookReader
import com.example.botttombarm3.FavoritesScreen
import com.example.botttombarm3.HomeDetailScreen
import com.example.botttombarm3.HomeScreen
import com.example.botttombarm3.ProfileScreen
import com.example.botttombarm3.SearchScreen

//home navigation
fun NavGraphBuilder.addHomeRoute(navController: NavHostController) {
    navigation(
        route = RootScreen.Home.route,
        startDestination = LeafScreen.Home.route
    ) {
        showHome(navController)
        showHomeDetail(navController)
    }
}

fun NavGraphBuilder.showHome(navController: NavHostController) {
    composable(route = LeafScreen.Home.route) {
        HomeScreen(
            showDetail = {
                navController.navigate(LeafScreen.HomeDetail.route)
            }
        )
    }
}

fun NavGraphBuilder.showHomeDetail(navController: NavHostController) {
    composable(route = LeafScreen.HomeDetail.route) {
        HomeDetailScreen(
            onBack = {
                navController.navigateUp()
            },navController
        )
    }
}
//end of home navigation

//search navigation
fun NavGraphBuilder.addSearchRoute(navController: NavHostController) {
    navigation(
        route = RootScreen.Search.route,
        startDestination = LeafScreen.Search.route
    ) {
        showSearch(navController)
        showSearchDetails(navController)

    }
}
fun NavGraphBuilder.showSearchDetails(navController: NavHostController) {
    composable(route = LeafScreen.BookReader.route) {
        BookReader()
    }
}
fun NavGraphBuilder.showSearch(navController: NavHostController) {
    composable(route = LeafScreen.Search.route) {
        SearchScreen(navController)
    }
}
//end of search navigation

//favorites navigation
fun NavGraphBuilder.addFavoritesRoute(navController: NavHostController) {
    navigation(
        route = RootScreen.Favorites.route,
        startDestination = LeafScreen.Favorites.route
    ) {
        showFavorites(navController)
    }
}

fun NavGraphBuilder.showFavorites(navController: NavHostController) {
    composable(route = LeafScreen.Favorites.route) {
        FavoritesScreen()
    }
}
//end of favorites navigation

//profile navigation
fun NavGraphBuilder.addProfileRoute(navController: NavHostController) {
    navigation(
        route = RootScreen.Profile.route,
        startDestination = LeafScreen.Profile.route
    ) {
        showProfile(navController)
    }
}

fun NavGraphBuilder.showProfile(navController: NavHostController) {
    composable(route = LeafScreen.Profile.route) {
        ProfileScreen()
    }
}
//end of profile navigation