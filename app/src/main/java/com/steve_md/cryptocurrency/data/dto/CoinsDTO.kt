package com.steve_md.cryptocurrency.data.dto


import com.google.gson.annotations.SerializedName
import com.steve_md.cryptocurrency.domain.model.Coin

data class CoinsDTO(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type")
    val type: String
)

fun CoinsDTO.toCoin() : Coin {
    return Coin(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        isActive = isActive
    )
}