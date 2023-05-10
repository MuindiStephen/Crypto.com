package com.steve_md.cryptocurrency.presentation.screens.coins_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.steve_md.cryptocurrency.domain.model.Coin
import com.steve_md.cryptocurrency.presentation.Screen
import com.steve_md.cryptocurrency.presentation.screens.coins_screen.components.CoinListItem

@Composable
fun CoinListScreen(
    coinsViewModel: CoinsViewModel = hiltViewModel(),
    navController: NavController
) {

    val state : CoinsState = coinsViewModel.coinState.value

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.listOfCoins) {  coinItem ->
                CoinListItem(
                    coin = coinItem,
                    onItemClickListener = {
                        navController.navigate(route = Screen.CoinsDetailsScreen.route + "/${coinItem.id}")
                    }
                )
            }
        }

        if (state.error.isNotBlank())  {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}