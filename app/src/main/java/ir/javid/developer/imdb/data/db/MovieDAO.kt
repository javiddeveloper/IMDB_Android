package ir.javid.developer.imdb.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable
import ir.javid.developer.imdb.data.db.model.InfoMovieEntity
import ir.javid.developer.imdb.data.rest.model.InfoMovie

/**
 * Developed by javid
 */

@Dao
interface MovieDAO {

    @Query("SELECT * FROM tbl_info_movie ORDER BY imdbID DESC")
    fun getAllMovieInfo():List<InfoMovieEntity>


    @Query("SELECT * FROM tbl_info_movie WHERE imdbID = :imdbID")
    fun getMovieInfo(imdbID: String): InfoMovieEntity


    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addMovieInfo(infoMovieEntity: InfoMovieEntity)


    @Query("DELETE FROM tbl_info_movie")
    suspend fun deleteAll()
}