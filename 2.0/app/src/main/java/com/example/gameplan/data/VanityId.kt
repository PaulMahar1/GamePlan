package com.example.gameplan.data

data class VanityId(
    val response: VanityResponse
)

data class VanityResponse(
    val steamid: String,
    val success: Int
)