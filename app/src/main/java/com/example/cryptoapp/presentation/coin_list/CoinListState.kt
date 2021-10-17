package com.example.cryptoapp.presentation.coin_list

import com.example.cryptoapp.domain.entity.coin.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val data: List<Coin> = emptyList(),
    val error: String = ""
)