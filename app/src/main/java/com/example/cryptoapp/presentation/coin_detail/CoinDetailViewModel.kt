package com.example.cryptoapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.core.Constants
import com.example.cryptoapp.core.Resoruce
import com.example.cryptoapp.domain.use_cases.coin.CoinUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinUseCases: CoinUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val state = mutableStateOf(CoinDetailState())

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoinById(coinId = coinId)
        }
    }

    private fun getCoinById(coinId: String) {
        viewModelScope.launch {
            coinUseCases.getCoinUseCase(coinId).collect { result ->
                when (result) {
                    is Resoruce.Loading -> {
                        state.value = CoinDetailState(isLoading = true)
                    }

                    is Resoruce.Success -> {
                        state.value = CoinDetailState(data = result.data)
                    }

                    is Resoruce.Error -> {
                        state.value =
                            CoinDetailState(error = result.message ?: "An Unexpected Error occurs")
                    }
                }
            }
        }

    }

    fun state(): State<CoinDetailState> = state
}