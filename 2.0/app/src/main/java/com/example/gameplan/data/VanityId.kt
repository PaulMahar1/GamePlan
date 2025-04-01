package com.example.gameplan.data

data class VanityId(
    val response: Response
)

data class Response(
    val steamid: String,
    val success: Int
)