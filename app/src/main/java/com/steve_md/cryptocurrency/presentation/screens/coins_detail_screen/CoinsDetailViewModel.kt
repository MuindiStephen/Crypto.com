package com.steve_md.cryptocurrency.presentation.screens.coins_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steve_md.cryptocurrency.common.PARAM_COIN_ID
import com.steve_md.cryptocurrency.common.Resource
import com.steve_md.cryptocurrency.domain.model.CoinDetail
import com.steve_md.cryptocurrency.domain.usecases.coin_detail.CoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn


@HiltViewModel
class CoinsDetailViewModel @Inject constructor(
    private val coinDetailUseCase: CoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _coinDetailState = mutableStateOf(CoinsDetailState())
    val coinDetailState: State<CoinsDetailState>
        get() = _coinDetailState

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoinsDetail(coinId = coinId)
        }

        // getCoinsDetail(coinId = savedStateHandle.get<String>(PARAM_COIN_ID))
    }

    private fun getCoinsDetail(coinId: String) {
        coinDetailUseCase(coinId).onEach { response ->
            when (response) {
                is Resource.Loading -> {
                    _coinDetailState.value = CoinsDetailState(loading = true)
                }
                is Resource.Error -> {
                    // _coinState.value = response.message?.let { CoinsState(error = it) }!!
                    _coinDetailState.value = CoinsDetailState(
                        error = response.message ?: "An unexpected error occurred!"
                    )
                }
                is Resource.Success -> {
                    _coinDetailState.value = CoinsDetailState(coinDetail = response.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class CoinsDetailState(
    val coinDetail: CoinDetail? = null,
    val loading: Boolean = false,
    val error: String = ""
)