package ir.javid.developer.imdb.data.db.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ir.javid.developer.imdb.data.db.MovieInfoDB
import ir.javid.developer.imdb.data.rest.model.InfoMovieEntity
import kotlinx.coroutines.launch

/**
 * Developed by javid
 */
class MovieInfoLiveData(application: Application) : AndroidViewModel(application) {

    private val repository : MovieInfoRepository

    private val allWords: LiveData<List<InfoMovieEntity>>
    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val infoDao = MovieInfoDB.getDatabase(application).MovieInfoDAO()
        repository = MovieInfoRepository(infoDao)
        allWords = repository.allMovieInfo
    }

    /**
     * The implementation of insert() in the database is completely hidden from the UI.
     * Room ensures that you're not doing any long running operations on
     * the main thread, blocking the UI, so we don't need to handle changing Dispatchers.
     * ViewModels have a coroutine scope based on their lifecycle called
     * viewModelScope which we can use here.
     */
    fun insert(infoMovieEntity: InfoMovieEntity) = viewModelScope.launch {
        repository.insert(infoMovieEntity)
    }

}