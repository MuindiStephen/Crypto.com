package com.steve_md.cryptocurrency.data.api

import com.steve_md.cryptocurrency.data.dto.CoinDetailDTO
import com.steve_md.cryptocurrency.data.dto.CoinsDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    // Get a list of all Coins
    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinsDTO>

    // Get Coin Detail
    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetail(
        @Path("coinId") coinId:String
    ) : CoinDetailDTO
}