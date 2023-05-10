package com.steve_md.cryptocurrency.presentation.screens.coins_detail_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.steve_md.cryptocurrency.presentation.screens.coins_detail_screen.CoinsDetailViewModel

@Composable
fun CoinDetailItem(
    coinsDetailViewModel: CoinsDetailViewModel = hiltViewModel()
) {
    val state = coinsDetailViewModel.coinDetailState.value

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        state.coinDetail?.let { coinDetail ->  
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
               item {
                   Row(
                       modifier = Modifier.fillMaxWidth(),
                       horizontalArrangement = Arrangement.SpaceBetween
                   ) {
                       Text(
                           style = MaterialTheme.typography.h2,
                           modifier = Modifier.weight(8f,true),
                           text = "${coinDetail.rank}. ${coinDetail.name} (${coinDetail.symbol})"
                       )

                       Text(
                           text = if (coinDetail.isActive) "active" else "inActive",
                           color = if (coinDetail.isActive) Color.Green else Color.Red,
                           fontStyle = FontStyle.Italic,
                           style = MaterialTheme.typography.body2,
                           textAlign = TextAlign.End,
                           modifier = Modifier
                               .align(CenterVertically)
                               .weight(2f, true)
                       )
                   }
                   Spacer(modifier = Modifier.height(16.dp))
                   Text(
                       text = coinDetail.type,
                       style = MaterialTheme.typography.h4
                   )
                   Spacer(modifier = Modifier.height(16.dp))
                   Text(
                       text = if (coinDetail.isNew) "isNew" else "isNotNew",
                       style = MaterialTheme.typography.body2
                   )
               }
            }
        }
    }
}