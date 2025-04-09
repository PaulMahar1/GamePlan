import com.example.gameplan.data.LinuxRequirements
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.gameplan.data.MacRequirements
import com.example.gameplan.data.PcRequirements
import com.example.gameplan.network.ObjectOrNullDeserializer
import com.google.gson.GsonBuilder

object RetrofitClient {
    private const val BASE_URL = "https://api.steampowered.com/"

    val api: SteamApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SteamApiService::class.java)
    }
}




object StoreClient {
    private const val BASE_URL = "http://store.steampowered.com/"

    val gson = GsonBuilder()
        .registerTypeAdapter(MacRequirements::class.java, ObjectOrNullDeserializer(MacRequirements::class.java))
        .registerTypeAdapter(LinuxRequirements::class.java, ObjectOrNullDeserializer(LinuxRequirements::class.java))
        .registerTypeAdapter(PcRequirements::class.java, ObjectOrNullDeserializer(PcRequirements::class.java))
        .create()


    val api: StoreApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(StoreApiService::class.java)
    }
}

