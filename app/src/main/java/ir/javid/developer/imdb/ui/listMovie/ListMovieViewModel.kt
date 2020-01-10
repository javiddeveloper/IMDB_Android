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

    val liveImdb: MutableLiveData<Imdb> = MutableLiveData()
    val artist: String = "batman"

    init {
//        MovieManager.instance.executeImdbList(artist)
        MovieManager.instance.executeImdbList(artist).subscribe { t: Imdb? -> liveImdb.postValue(t) }
    }

    fun callList(moveiName: String) {
//        MovieManager.instance.executeImdbList(moveiName).subscribe(->liveImdb.postValue())
        MovieManager.instance.executeImdbList(moveiName).subscribe { t: Imdb? -> liveImdb.postValue(t) }
    }

}
