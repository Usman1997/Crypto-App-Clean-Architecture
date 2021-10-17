package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.remote.CoinPaprikaApi
import com.example.cryptoapp.data.remote.dto.coin.CoinDto
import com.example.cryptoapp.data.remote.dto.coin_detail.CoinDetailDto
import com.example.cryptoapp.domain.repository.CoinRepository

class CoinRepositoryImpl(private val coinPaprikaApi: CoinPaprikaApi): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
       return coinPaprikaApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinPaprikaApi.getCoinById(coinId)
    }
}