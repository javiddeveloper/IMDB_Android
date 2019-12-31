package ir.javid.developer.imdb.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.javid.developer.imdb.data.rest.model.InfoMovieEntity

/**
 * Developed by javid
 */

@Dao
interface MovieInfoDAO {

    @Query("SELECT * FROM tbl_info_movie ORDER BY infoId DESC")
    fun getAllMovieInfo(): LiveData<List<InfoMovieEntity>>


    @Query("SELECT * FROM tbl_info_movie WHERE infoId > :infoId")
    fun getMovieInfo(infoId: Int): InfoMovieEntity


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieInfo(infoMovieEntity: InfoMovieEntity)


    @Query("DELETE FROM tbl_info_movie")
    suspend fun deleteAll()
}