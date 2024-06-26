package com.mycompany.currencytracker.common

typealias RootError = Error
sealed interface Resource<out D, out E: RootError> {
    data class Success<out D, out E: RootError>(val data: D): Resource<D, E>
    data class Error<out D, out E: RootError>(val error: E): Resource<D, E>
    class Loading<out D, out E: RootError>(val data: D? = null) : Resource<D, E>
}
