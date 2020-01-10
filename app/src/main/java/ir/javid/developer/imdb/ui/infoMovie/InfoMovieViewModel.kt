package ir.javid.developer.imdb.ui.infoMovie

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.javid.developer.imdb.data.db.model.InfoMovieEntity
import ir.javid.developer.imdb.data.repository.MovieManager
import ir.javid.developer.imdb.data.rest.model.InfoMovie
import ir.javid.developer.imdb.ui.ParentViewModel

class InfoMovieViewModel : ViewModel() {

    val liveInfoMovie: MutableLiveData<InfoMovieEntity> = MutableLiveData()


    fun getMovieInfo(id: String) {
//        MovieManager.instance.executeImdbInfoMovie(id)
//            .subscribe { t: InfoMovieEntity? -> liveInfoMovie.postValue(t) }
    }

}
