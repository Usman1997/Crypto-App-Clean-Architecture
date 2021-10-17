package com.example.cryptoapp.domain.use_cases.get_coin

import com.example.cryptoapp.core.Resoruce
import com.example.cryptoapp.data.remote.dto.coin_detail.toCoinDetail
import com.example.cryptoapp.domain.entity.coin_detail.CoinDetail
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinUseCase(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resoruce<CoinDetail>> = flow {
        try {
            emit(Resoruce.Loading<CoinDetail>())
            val coinDetail = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(Resoruce.Success<CoinDetail>(coinDetail))
        } catch (e: HttpException) {
            emit(Resoruce.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resoruce.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }


}