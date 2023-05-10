package com.steve_md.cryptocurrency.presentation.screens.coins_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steve_md.cryptocurrency.common.Resource
import com.steve_md.cryptocurrency.domain.model.Coin
import com.steve_md.cryptocurrency.domain.usecases.coin.CoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
  private val coinUseCase: CoinUseCase
) : ViewModel() {
    private val _coinState = mutableStateOf(CoinsState())
    val coinState:State<CoinsState>
    get() = _coinState

    init {
        getAllCoins()
    }

    private fun getAllCoins() {
        coinUseCase().onEach { response ->
            when(response) {
                is Resource.Loading -> {
                   _coinState.value = CoinsState(loading = true)
                }
                is Resource.Error -> {
                    // _coinState.value = response.message?.let { CoinsState(error = it) }!!
                    _coinState.value = CoinsState(error = response.message ?: "An unexpected error occurred!")
                }
                is Resource.Success -> {
                    _coinState.value = CoinsState(listOfCoins = response.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class CoinsState(
    val listOfCoins: List<Coin> = emptyList(),
    val loading: Boolean =  false,
    val error: String = ""
)