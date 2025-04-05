package com.example.gameplan.data
import com.google.gson.annotations.SerializedName
import okhttp3.Response

data class VanityId(
    val response: VanityResponse
)

data class VanityResponse(
    val steamid: String,
    val success: Int
)