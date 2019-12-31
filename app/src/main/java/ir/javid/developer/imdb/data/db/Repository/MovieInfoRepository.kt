package ir.javid.developer.imdb.data.db.Repository

import androidx.lifecycle.LiveData
import ir.javid.developer.imdb.data.db.MovieInfoDAO
import ir.javid.developer.imdb.data.rest.model.InfoMovieEntity

/**
 * Developed by javid
 */

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class MovieInfoRepository(private val movieInfoDAO: MovieInfoDAO) {
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allMovieInfo: LiveData<List<InfoMovieEntity>> = movieInfoDAO.getAllMovieInfo()

    suspend fun insert(entity: InfoMovieEntity) {
        movieInfoDAO.addMovieInfo(entity)
    }
}