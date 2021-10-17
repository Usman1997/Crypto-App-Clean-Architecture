package com.example.cryptoapp.presentation.coin_detail

import com.example.cryptoapp.domain.entity.coin.Coin
import com.example.cryptoapp.domain.entity.coin_detail.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val data: CoinDetail? = null,
    val error: String = ""
)