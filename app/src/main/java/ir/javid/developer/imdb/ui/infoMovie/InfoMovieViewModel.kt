package ir.javid.developer.imdb.ui.infoMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.javid.developer.imdb.data.repository.MoveiManager
import ir.javid.developer.imdb.data.rest.model.InfoMovie
import ir.javid.developer.imdb.data.rest.RestManager

class InfoMovieViewModel : ViewModel() {

    val liveInfoMovie: MutableLiveData<InfoMovie> = MoveiManager.instance.liveInfoMovie
    fun getMovieInfo(id: String) {
        RestManager.instance.callImdbInfoMovie(id)
    }

}
