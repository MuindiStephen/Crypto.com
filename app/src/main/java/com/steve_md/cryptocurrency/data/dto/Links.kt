package com.steve_md.cryptocurrency.data.dto


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("explorer")
    val explorer: List<String>,
    @SerializedName("website")
    val website: List<String>
)