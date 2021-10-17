package com.example.cryptoapp.domain.entity.coin

import com.google.gson.annotations.SerializedName


data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)