package com.mycompany.currencytracker.domain.model.user

import com.mycompany.currencytracker.data.remote.dto.user.CryptoFollowedDto
import com.mycompany.currencytracker.domain.model.currency.ICrypto

data class FollowedCrypto(
    val numberInList: Int,
    override val symbol: String,
    override val market_cap: Long?,
    override val image: String?,
    override val _24h: Double?,
    override val _7d: Double?,
    override val _30d: Double?,
    override val rate: Double
): ICrypto


fun CryptoFollowedDto.toCryptoFollowed() =
    FollowedCrypto(numberInList, symbol, market_cap, image, _24h, _7d, _1m, currentPrice)