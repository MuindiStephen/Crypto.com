package com.steve_md.cryptocurrency.domain.usecases.coin

import com.steve_md.cryptocurrency.common.Resource
import com.steve_md.cryptocurrency.data.dto.toCoin
import com.steve_md.cryptocurrency.domain.model.Coin
import com.steve_md.cryptocurrency.domain.repository.Repository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinUseCase @Inject constructor(
    private val repository: Repository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getAllCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}