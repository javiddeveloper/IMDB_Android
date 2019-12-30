package ir.javid.developer.imdb.ui.listMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.javid.developer.imdb.data.rest.model.Imdb
import ir.javid.developer.imdb.data.rest.RestManager

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
