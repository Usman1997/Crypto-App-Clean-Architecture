package com.example.cryptoapp.domain.use_cases.coin

import com.example.cryptoapp.domain.use_cases.get_coin.GetCoinUseCase
import com.example.cryptoapp.domain.use_cases.get_coins.GetCoinsUseCase

data class CoinUseCases(
    val getCoinUseCase: GetCoinUseCase,
    val getCoinsUseCase: GetCoinsUseCase
)