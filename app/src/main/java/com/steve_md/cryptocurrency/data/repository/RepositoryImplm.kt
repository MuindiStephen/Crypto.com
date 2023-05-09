package com.steve_md.cryptocurrency.data.repository

import com.steve_md.cryptocurrency.data.dto.CoinDetailDTO
import com.steve_md.cryptocurrency.data.dto.CoinsDTO
import com.steve_md.cryptocurrency.domain.repository.Repository

class RepositoryImplm : Repository {
    override suspend fun getAllCoins(): List<CoinsDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailDTO {
        TODO("Not yet implemented")
    }
}