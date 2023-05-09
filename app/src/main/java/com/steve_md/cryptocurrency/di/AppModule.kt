package com.steve_md.cryptocurrency.di

import com.steve_md.cryptocurrency.common.BASE_URL
import com.steve_md.cryptocurrency.data.api.ApiService
import com.steve_md.cryptocurrency.data.repository.RepositoryImplm
import com.steve_md.cryptocurrency.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofitService() : ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesRepository(apiService: ApiService) : Repository {
        return RepositoryImplm(apiService)
    }
}