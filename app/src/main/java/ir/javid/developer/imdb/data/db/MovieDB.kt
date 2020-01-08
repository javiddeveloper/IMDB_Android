package ir.javid.developer.imdb.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.javid.developer.imdb.data.db.model.InfoMovieEntity
import ir.javid.developer.imdb.tools.ContextModel

/**
 * Developed by javid
 */
@Database(entities = arrayOf(InfoMovieEntity::class), version = 1, exportSchema = false)
abstract class MovieDB : RoomDatabase() {

    abstract fun movieDAO(): MovieDAO
    companion object {
//        @Volatile
        private var INSTANCE: MovieDB? = null

        fun getDatabase(): MovieDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    ContextModel.context!!.applicationContext,
                    MovieDB::class.java,
                    "Movie_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}


