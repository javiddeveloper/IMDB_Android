package ir.javid.developer.imdb.sections.listMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ir.javid.developer.imdb.model.Imdb
import ir.javid.developer.imdb.network.RestManager
import java.util.*

/**
 * Developed by javid
 */
class ListMovieViewModel : ViewModel()/*, java.util.Observer*/ {


    var mutableLiveData: MutableLiveData<Imdb> = RestManager.instance.listImdb
    private val artist: String = "batman"


    init {
        RestManager.instance.callImdbList(artist)
    }

}
