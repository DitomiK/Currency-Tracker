package com.mycompany.currencytracker.presentation.crypto_list

import com.mycompany.currencytracker.domain.model.currency.crypto.CryptoDetails

data class CryptoListState(
    val isLoading: Boolean = false,
    val cryptos: List<CryptoDetails> = emptyList(),
    val error: String = ""

)