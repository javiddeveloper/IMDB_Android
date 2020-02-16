package ir.javid.developer.imdb.ui.listMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.functions.Consumer
import ir.javid.developer.imdb.data.repository.MovieManager
import ir.javid.developer.imdb.data.rest.model.Imdb
import ir.javid.developer.imdb.data.rest.RestManager

/**
 * Developed by javid
 */
class ListMovieViewModel : ViewModel() {

    val liveImdb: MutableLiveData<Imdb> = MutableLiveData()
    private val artist: String = "batman"

    init {
//        MovieManager.instance.executeImdbList(artist)
        MovieManager.instance.executeImdbList(artist).subscribe(Consumer
        {
            liveImdb.postValue(it) },
            Consumer {
                it.printStackTrace()
            })
    }

    fun callList(moveiName: String) {
//        MovieManager.instance.executeImdbList(moveiName).subscribe(->liveImdb.postValue())
        MovieManager.instance.executeImdbList(moveiName)
            .subscribe(Consumer {
                liveImdb.postValue(it)
            },
            Consumer {
                it.printStackTrace()
            })
    }

}
