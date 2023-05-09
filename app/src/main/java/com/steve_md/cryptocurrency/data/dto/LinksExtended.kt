package com.steve_md.cryptocurrency.data.dto


import com.google.gson.annotations.SerializedName

data class LinksExtended(
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)