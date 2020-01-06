package ir.javid.developer.imdb.data.repository

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import ir.javid.developer.imdb.data.db.MovieDAO
import ir.javid.developer.imdb.data.db.MovieDB
import ir.javid.developer.imdb.data.db.model.InfoMovieEntity
import ir.javid.developer.imdb.data.rest.RestManager
import ir.javid.developer.imdb.data.rest.model.Imdb
import ir.javid.developer.imdb.data.rest.model.InfoMovie
import ir.javid.developer.imdb.tools.ContextModel
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.concurrent.thread

/**
 * Developed by javid
 */
class MovieManager : Observer {
    val liveInfoMovie: MutableLiveData<InfoMovieEntity> = MutableLiveData()
    val liveImdb: MutableLiveData<Imdb> = MutableLiveData()

    companion object {
        val instance: MovieManager by lazy {
            MovieManager()
        }
    }

    init {
        RestManager.instance.addObserver(this)

    }

    fun executeImdbList(artist: String) {
        RestManager.instance.callImdbList(artist)
    }

    fun executeImdbInfoMovie(context: Context, id: String) {
//        liveInfoMovie.value = MovieDB.getDatabase(context).movieDAO().getMovieInfo(id).value
        RestManager.instance.callImdbInfoMovie(id)
    }

    override fun update(observable: Observable?, any: Any?) {
        if (observable is RestManager) {
            when (any) {
                is Imdb -> {
                    liveImdb.value = any
                }
                is InfoMovie -> {
//                    AsyncTask.execute( saveToDB(convertDataToDAO(any))
                    AsyncTask.execute { saveToDB(convertDataToDAO(any)) }

                }
            }
        }
    }

    private fun saveToDB(infoMovieEntity: InfoMovieEntity?) {
        MovieDB.getDatabase(ContextModel.context!!).movieDAO().addMovieInfo(infoMovieEntity!!)
        liveInfoMovie.value = MovieDB.getDatabase(ContextModel.context!!).movieDAO().getMovieInfo(infoMovieEntity.imdbID).value
    }


    private fun convertDataToDAO(any: InfoMovie): InfoMovieEntity? {
        return InfoMovieEntity(
            0,
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