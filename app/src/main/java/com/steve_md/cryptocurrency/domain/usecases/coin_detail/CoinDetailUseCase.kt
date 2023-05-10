package com.steve_md.cryptocurrency.domain.usecases.coin_detail

import com.steve_md.cryptocurrency.common.Resource
import com.steve_md.cryptocurrency.data.dto.toCoinDetail
import com.steve_md.cryptocurrency.domain.model.CoinDetail
import com.steve_md.cryptocurrency.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    private val repository: Repository
) {
        operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
            try {
                emit(Resource.Loading())
                val coinDetail = repository.getCoinDetail(coinId).toCoinDetail()
                emit(Resource.Success(coinDetail))
            } catch(e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
            } catch(e: IOException) {
                emit(Resource.Error("Couldn't reach server. Check your internet connection."))
            }
        }
    }
