package com.steve_md.cryptocurrency.domain.model


/**
 * Lighter Model class which renders our data to the UI
 */
data class Coin (
    val id: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val isActive:Boolean
)