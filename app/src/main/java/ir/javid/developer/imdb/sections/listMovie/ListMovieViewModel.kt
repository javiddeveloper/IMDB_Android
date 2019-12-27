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
class ListMovieViewModel : ViewModel(), java.util.Observer {


    var mutableLiveData: MutableLiveData<Imdb> = MutableLiveData()
    private val artist: String = "batman"


    init {

        RestManager.instance.addObserver(this)
        RestManager.instance.callImdbList(artist)
    }


    override fun update(observable: Observable?, any: Any?) {
        if (observable is RestManager)
            if (any is Imdb)
                mutableLiveData.value = any
    }
}
