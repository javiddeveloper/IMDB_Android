package ir.javid.developer.imdb.network

import androidx.lifecycle.MutableLiveData
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.disposables.CompositeDisposable
//import io.reactivex.schedulers.Schedulers
import ir.javid.developer.imdb.model.Imdb
import ir.javid.developer.imdb.model.InfoMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Developed by javid
 */
class RestManager {
    private val api = ApiClient().loadData()
    val listInfoMoviev: MutableLiveData<InfoMovie> = MutableLiveData()
    val listImdb: MutableLiveData<Imdb> = MutableLiveData()

    companion object {
        val instance: RestManager by lazy {
            RestManager()
        }
    }

    fun callImdbList(artist: String) {

        val call = api.getImdbList(artist)
        call.enqueue(object : Callback<Imdb> {
            override fun onFailure(call: Call<Imdb>, t: Throwable) {
                listImdb.value = null

            }

            override fun onResponse(call: Call<Imdb>, response: Response<Imdb>) {
                if (response.isSuccessful) {
                    listImdb.value = response.body()
                }
            }
        })
    }

    fun callImdbInfoMovie(imdbID: String) {

        val call = api.getInfoFilm(imdbID)
        call.enqueue(object : Callback<InfoMovie> {
            override fun onFailure(call: Call<InfoMovie>, t: Throwable) {
                listInfoMoviev.value = null

            }

            override fun onResponse(call: Call<InfoMovie>, response: Response<InfoMovie>) {
                if (response.isSuccessful) {
                    listInfoMoviev.value = response.body()
                }
            }
        })
    }


}

