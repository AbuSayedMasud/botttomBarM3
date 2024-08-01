package com.example.botttombarm3.shell

sealed class LeafScreen(val route: String) {
    data object Home : LeafScreen("home")
    data object Search : LeafScreen("search")
    data object Favorites : LeafScreen("favorites")
    data object Profile : LeafScreen("profile")
    data object HomeDetail : LeafScreen("home_detail")
    data object BookReader : LeafScreen("book_reader")
}