package ir.javid.developer.imdb.ui.listMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.javid.developer.imdb.data.repository.MovieManager
import ir.javid.developer.imdb.data.rest.model.Imdb
import ir.javid.developer.imdb.data.rest.RestManager

/**
 * Developed by javid
 */
class ListMovieViewModel : ViewModel() {

    val liveImdb: MutableLiveData<Imdb> = MovieManager.instance.liveImdb
    val artist: String = "batman"

    init {
        MovieManager.instance.executeImdbList(artist)
    }

    fun callList(moveiName: String) {
        MovieManager.instance.executeImdbList(moveiName)
    }

}
