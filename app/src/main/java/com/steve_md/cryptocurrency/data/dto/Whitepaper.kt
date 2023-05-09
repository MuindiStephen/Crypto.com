package com.steve_md.cryptocurrency.data.dto


import com.google.gson.annotations.SerializedName

data class Whitepaper(
    @SerializedName("link")
    val link: Any,
    @SerializedName("thumbnail")
    val thumbnail: Any
)