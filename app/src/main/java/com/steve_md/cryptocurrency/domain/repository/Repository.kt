package com.steve_md.cryptocurrency.domain.repository

import com.steve_md.cryptocurrency.data.dto.CoinDetailDTO
import com.steve_md.cryptocurrency.data.dto.CoinsDTO

interface Repository {
    suspend fun getAllCoins() : List<CoinsDTO>
    suspend fun getCoinDetail(coinId: String) : CoinDetailDTO
}