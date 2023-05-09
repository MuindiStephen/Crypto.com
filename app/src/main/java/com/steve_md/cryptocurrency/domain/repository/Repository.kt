package com.steve_md.cryptocurrency.domain.repository

import com.steve_md.cryptocurrency.data.api.ApiService
import com.steve_md.cryptocurrency.data.dto.CoinDetailDTO
import com.steve_md.cryptocurrency.data.dto.CoinsDTO
import com.steve_md.cryptocurrency.domain.model.Coin

interface Repository {
    suspend fun getAllCoins() : List<CoinsDTO>
    suspend fun getCoinDetail(coinId: String) : CoinDetailDTO
}