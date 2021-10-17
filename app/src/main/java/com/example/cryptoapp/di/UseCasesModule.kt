package com.example.cryptoapp.di

import com.example.cryptoapp.domain.repository.CoinRepository
import com.example.cryptoapp.domain.use_cases.coin.CoinUseCases
import com.example.cryptoapp.domain.use_cases.get_coin.GetCoinUseCase
import com.example.cryptoapp.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideCoinUseCases(coinRepository: CoinRepository): CoinUseCases {
        return CoinUseCases(
            GetCoinUseCase(coinRepository),
            GetCoinsUseCase(coinRepository)
        )
    }
}