package com.example.cryptoapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.core.Resoruce
import com.example.cryptoapp.domain.use_cases.coin.CoinUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinUseCases: CoinUseCases
) : ViewModel() {
    private val state = mutableStateOf(CoinListState())

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            coinUseCases.getCoinsUseCase().collect { result ->
                when (result) {
                    is Resoruce.Loading -> {
                        state.value = CoinListState(isLoading = true)
                    }

                    is Resoruce.Success -> {
                        state.value = CoinListState(data = result.data ?: emptyList())
                    }

                    is Resoruce.Error -> {
                        state.value =
                            CoinListState(error = result.message ?: "An Unexpected Error occurs")
                    }
                }
            }
        }
    }

    fun state(): State<CoinListState> = state
}