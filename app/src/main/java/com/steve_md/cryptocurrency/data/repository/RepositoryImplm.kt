package com.steve_md.cryptocurrency.data.repository

import com.steve_md.cryptocurrency.data.api.ApiService
import com.steve_md.cryptocurrency.data.dto.CoinDetailDTO
import com.steve_md.cryptocurrency.data.dto.CoinsDTO
import com.steve_md.cryptocurrency.domain.repository.Repository
import javax.inject.Inject

class RepositoryImplm @Inject constructor(
    private val apiService: ApiService
) : Repository  {
    override suspend fun getAllCoins(): List<CoinsDTO> {
       return apiService.getCoins()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailDTO {
        return apiService.getCoinDetail(coinId)
    }
}