package com.example.botttombarm3.shell

sealed class RootScreen(val route: String) {
    data object Home : RootScreen("home_root")
    data object Search : RootScreen("search_root")
    data object Favorites : RootScreen("favorites_root")
    data object Profile : RootScreen("profile_root")
}

