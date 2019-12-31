package ir.javid.developer.imdb.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.javid.developer.imdb.data.rest.model.InfoMovieEntity

/**
 * Developed by javid
 */
@Database(entities = arrayOf(InfoMovieEntity::class), version = 1, exportSchema = true)
abstract class MovieInfoDB : RoomDatabase() {

    abstract fun MovieInfoDAO(): MovieInfoDAO
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MovieInfoDB? = null

        fun getDatabase(context: Context): MovieInfoDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieInfoDB::class.java,
                    "Movie_info_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}


