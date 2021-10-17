package com.example.cryptoapp.domain.use_cases.get_coins

import com.example.cryptoapp.core.Resoruce
import com.example.cryptoapp.data.remote.dto.coin.toCoin
import com.example.cryptoapp.domain.entity.coin.Coin
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinsUseCase(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(): Flow<Resoruce<List<Coin>>> = flow {
        try {
            emit(Resoruce.Loading<List<Coin>>())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resoruce.Success(coins))
        } catch (e: HttpException) {
            emit(Resoruce.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resoruce.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}