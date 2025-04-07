import com.example.gameplan.data.FriendList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.gameplan.data.GameInfo
import com.example.gameplan.data.GameTags
import com.example.gameplan.data.OwnedGames
import com.example.gameplan.data.PlayerSummary
import com.example.gameplan.data.VanityId

interface SteamApiService {

    @GET("ISteamUser/ResolveVanityURL/v0001/")
    suspend fun getSteamId(
        @Query("key") apiKey: String,
        @Query("vanityurl") username: String
    ): Response<VanityId>

    @GET("ISteamUser/GetFriendList/v0001/")
    suspend fun getFriendList(
        @Query("key") apiKey: String,
        @Query("steamid") steamId: String,
        @Query("relationship") relationship: String = "friend"
    ): Response<FriendList>

    @GET("IPlayerService/GetOwnedGames/v0001/")
    suspend fun getOwnedGames(
        @Query("key") apiKey: String,
        @Query("steamid") steamId: String,
        @Query("format") format: String = "json"
    ): Response<OwnedGames>

    @GET("ISteamUser/GetPlayerSummaries/v0002/")
    suspend fun getPlayerSummary(
        @Query("key") apiKey: String,
        @Query("steamids") steamIds: String
    ): Response<PlayerSummary>


    @GET("https://steamspy.com/api.php")
    suspend fun getGameTags(
        @Query("request") request: String = "appdetails",
        @Query("appid") gameId: String
    ): Response<GameTags>
}

interface StoreApiService {

    @GET("api/appdetails")
    suspend fun getGameDetails(
        @Query("appids") gameId: String
    ): Response<GameInfo>

}



