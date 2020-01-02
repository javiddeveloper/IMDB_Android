package ir.javid.developer.imdb.ui.infoMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.javid.developer.imdb.data.repository.MovieManager
import ir.javid.developer.imdb.data.rest.model.InfoMovie

class InfoMovieViewModel : ViewModel() {

    val liveInfoMovie: MutableLiveData<InfoMovie> = MovieManager.instance.liveInfoMovie
    fun getMovieInfo(id: String) {
        MovieManager.instance.executeImdbInfoMovie(id)
    }

}
