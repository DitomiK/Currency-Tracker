package com.mycompany.currencytracker.domain.use_case.crypto

import com.mycompany.currencytracker.common.Resource
import com.mycompany.currencytracker.common.debugLog
import com.mycompany.currencytracker.domain.model.currency.crypto.CryptoDetails
import com.mycompany.currencytracker.domain.model.currency.fiat.Currency
import com.mycompany.currencytracker.domain.repository.CryptosRepository
import com.mycompany.currencytracker.domain.repository.CurrenciesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCryptoDetailsUseCase @Inject constructor(
    private val repository: CryptosRepository
) {
    operator fun invoke(
        symbol: String
    ): Flow<Resource<CryptoDetails>> = flow {
        try {
            emit(Resource.Loading())
            debugLog("Crypto symbol $symbol")
            val cryptoResponse = repository.getLatestBySymbol(symbol)
            emit(Resource.Success(cryptoResponse.toCrypto()))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "error"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        }
    }
}