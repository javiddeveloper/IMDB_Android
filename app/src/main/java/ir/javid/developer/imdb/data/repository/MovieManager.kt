package ir.javid.developer.imdb.data.repository

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.Function
import ir.javid.developer.imdb.data.db.MovieDAO
import ir.javid.developer.imdb.data.db.MovieDB
import ir.javid.developer.imdb.data.db.model.InfoMovieEntity
import ir.javid.developer.imdb.data.rest.RestManager
import ir.javid.developer.imdb.data.rest.model.Imdb
import ir.javid.developer.imdb.data.rest.model.InfoMovie
import ir.javid.developer.imdb.tools.ContextModel
import ir.javid.developer.imdb.tools.Utils
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.concurrent.thread

/**
 * Developed by javid
 */
class MovieManager {
    val liveInfoMovie: MutableLiveData<InfoMovieEntity> = MutableLiveData()
    val liveImdb: MutableLiveData<Imdb> = MutableLiveData()

    companion object {
        val instance: MovieManager by lazy {
            MovieManager()
        }
    }

    fun executeImdbList(artist: String) : Observable<Imdb> {
//        RestManager.instance.callImdbList(artist)
        return RestManager.instance.callImdbList(artist)

    }

//    fun executeImdbInfoMovie(imdbID: String): Observable<InfoMovieEntity> {
//        return if (Utils.isNetworkAccess()) {
//            RestManager.instance.callImdbInfoMovie(imdbID)
//                .doOnNext { t: InfoMovie? -> saveToDB(convertDataToDAO(t!!)) }
//                .flatMap { MovieDB.getDatabase().movieDAO().getMovieInfo(imdbID) }
//
//        } else {
////                AsyncTask.execute {
//            MovieDB.getDatabase().movieDAO().getMovieInfo(imdbID)
////                }
//        }
//    }


    @Synchronized
    private fun saveToDB(entity: InfoMovieEntity?) {
        MovieDB.getDatabase().movieDAO().addMovieInfo(entity!!)
//        liveInfoMovie.postValue(
//            MovieDB
//                .getDatabase()
//                .movieDAO()
//                .getMovieInfo(entity.imdbID)
//        )
    }


    private fun convertDataToDAO(any: InfoMovie): InfoMovieEntity? {
        return InfoMovieEntity(
            any.title,
            any.year,
            any.rated,
            any.released,
            any.runtime,
            any.genre,
            any.director,
            any.writer,
            any.actors,
            any.plot,
            any.language,
            any.country,
            any.awards,
            any.poster,
            any.metascore,
            any.imdbRating,
            any.imdbVotes,
            any.imdbID,
            any.type,
            any.dVD,
            any.boxOffice,
            any.production,
            any.website,
            any.response
        )
    }


}