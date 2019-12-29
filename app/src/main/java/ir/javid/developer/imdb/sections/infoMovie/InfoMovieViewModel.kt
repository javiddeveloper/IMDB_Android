package ir.javid.developer.imdb.sections.infoMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.javid.developer.imdb.model.Imdb
import ir.javid.developer.imdb.model.InfoMovie
import ir.javid.developer.imdb.network.RestManager
import java.util.*

class InfoMovieViewModel : ViewModel() {


    var mutableLiveData: MutableLiveData<InfoMovie> = RestManager.instance.listInfoMoviev

    fun getMovieInfo(id: String) {
        RestManager.instance.callImdbInfoMovie(id)
    }

}
