package ir.javid.developer.imdb.data.repository

import androidx.lifecycle.MutableLiveData
import ir.javid.developer.imdb.data.rest.RestManager
import ir.javid.developer.imdb.data.rest.model.Imdb
import ir.javid.developer.imdb.data.rest.model.InfoMovie
import java.util.*

/**
 * Developed by javid
 */
class MovieManager : Observer {
    val liveInfoMovie: MutableLiveData<InfoMovie> = MutableLiveData()
    val liveImdb: MutableLiveData<Imdb> = MutableLiveData()

    companion object {
        val instance: MovieManager by lazy { MovieManager() }
    }

    init {
        RestManager.instance.addObserver(this)
    }

    fun executeImdbList(artist: String) {
        RestManager.instance.callImdbList(artist)
    }

    fun executeImdbInfoMovie(id: String) {
        RestManager.instance.callImdbInfoMovie(id)
    }

    override fun update(observable: Observable?, any: Any?) {
        if (observable is RestManager) {
            when (any) {
                is Imdb -> {
                    liveImdb.value = any
                }
                is InfoMovie -> {
                    liveInfoMovie.value = any
                }
            }
        }
    }


}