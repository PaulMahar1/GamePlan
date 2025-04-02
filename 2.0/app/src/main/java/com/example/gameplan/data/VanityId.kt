package com.example.gameplan.data
import com.google.gson.annotations.SerializedName

data class VanityId(
    val response: Response
)

data class VanityResponse(
    @SerializedName("response")
    val steamid: String,
    val success: Int
)