package ir.javid.developer.imdb.data.repository

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ir.javid.developer.imdb.data.db.MovieDB
import ir.javid.developer.imdb.data.db.model.InfoMovieEntity
import ir.javid.developer.imdb.data.rest.RestManager
import ir.javid.developer.imdb.data.rest.model.Imdb
import ir.javid.developer.imdb.data.rest.model.InfoMovie
import ir.javid.developer.imdb.tools.Utils
import java.util.concurrent.Callable

/**
 * Developed by javid
 */
class MovieManager {
    companion object {
        val instance: MovieManager by lazy {
            MovieManager()
        }
    }

    fun executeImdbList(artist: String): Observable<Imdb> {
        return RestManager.instance.callImdbList(artist)
    }

    fun executeImdbInfoMovie(imdbID: String): Observable<InfoMovieEntity> {
        return if (Utils.isNetworkAccess()) {
            RestManager.instance.callImdbInfoMovie(imdbID)
                .subscribeOn(Schedulers.io())
                .map { infoMovie: InfoMovie ->
                    convertDataToDAO(infoMovie)
                }
                .doOnNext {
                    saveToDB(it)
                }
        } else {
            Observable.fromCallable(Callable {
                MovieDB.getDatabase().movieDAO().getMovieInfo(imdbID)
            })
                .subscribeOn(Schedulers.io())
        }
    }


    @Synchronized
    private fun saveToDB(entity: InfoMovieEntity?) {
        MovieDB.getDatabase().movieDAO().addMovieInfo(entity!!)
    }


    private fun convertDataToDAO(any: InfoMovie): InfoMovieEntity {
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