import android.content.Context
import androidx.room.Room
import com.example.gameplan.data.database.GameDatabase

object DatabaseProvider {
    @Volatile
    private var INSTANCE: GameDatabase? = null

    fun getDatabase(context: Context): GameDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                GameDatabase::class.java,
                "game_database"
            )
                .fallbackToDestructiveMigration() // this will wipe the data if migration is missing or the schema changes
                .build()
            INSTANCE = instance
            instance
        }
    }
}