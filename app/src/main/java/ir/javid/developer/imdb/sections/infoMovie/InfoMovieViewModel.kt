package ir.javid.developer.imdb.sections.infoMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.javid.developer.imdb.model.Imdb
import ir.javid.developer.imdb.model.InfoMovie
import ir.javid.developer.imdb.network.RestManager
import java.util.*

class InfoMovieViewModel : ViewModel(), Observer {


    var mutableLiveData: MutableLiveData<InfoMovie> = MutableLiveData()
//    private var imdbID: String = "tt0372784"

    fun init(imdbID : String) {

        RestManager.instance.addObserver(this)
        RestManager.instance.callImdbInfoMovie(imdbID)
    }


    override fun update(observable: Observable?, any: Any?) {
        if (observable is RestManager)
            if (any is InfoMovie)
                mutableLiveData.value = any
    }
}
