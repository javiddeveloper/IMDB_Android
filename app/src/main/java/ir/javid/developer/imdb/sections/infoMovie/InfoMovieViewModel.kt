package ir.javid.developer.imdb.sections.infoMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.javid.developer.imdb.model.Imdb
import ir.javid.developer.imdb.model.InfoMovie
import ir.javid.developer.imdb.network.RestManager
import java.util.*

class InfoMovieViewModel : ViewModel(),Observer {


    var mutableLiveData: MutableLiveData<InfoMovie> = MutableLiveData()
    private lateinit var imdbID: String


    init {

        RestManager.instance.addObserver(this)
        RestManager.instance.callImdbList(imdbID)
    }


    override fun update(observable: Observable?, any: Any?) {
        if (observable is RestManager)
            if (any is InfoMovie)
                mutableLiveData.value = any
    }
}
