package com.steve_md.cryptocurrency.presentation

sealed class Screen (val route:String) {
    object CoinsScreen : Screen("coins_screen")
    object CoinsDetailsScreen : Screen("coins_details_screen")
}