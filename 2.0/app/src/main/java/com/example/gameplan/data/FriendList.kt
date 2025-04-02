package com.example.gameplan.data
import com.google.gson.annotations.SerializedName

data class FriendList(
    @SerializedName("friendslist")
    val friendsListResponse: FriendsListResponse
)

data class FriendsListResponse(
    @SerializedName("friends")
    val friends: List<Friend?>?
)

data class Friend(
    @SerializedName("friend_since")
    val friendSince: Int?,
    @SerializedName("relationship")
    val relationship: String?,
    @SerializedName("steamid")
    val steamid: String?
)


