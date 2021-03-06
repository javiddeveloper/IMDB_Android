package ir.javid.developer.imdb.data.rest

import ir.javid.developer.imdb.data.rest.model.Address
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.disposables.CompositeDisposable
//import io.reactivex.schedulers.Schedulers
import ir.javid.developer.imdb.data.rest.model.Imdb
import ir.javid.developer.imdb.data.rest.model.InfoMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Developed by javid
 */
class RestManager : Observable() {
    private val api = ApiClient().loadData()

    companion object {
        val instance: RestManager by lazy {
            RestManager()
        }
    }

    fun callImdbList(artist: String) {
        val call = api.getImdbList(Address.instance.api, artist)
        call.enqueue(object : Callback<Imdb> {
            override fun onFailure(call: Call<Imdb>, t: Throwable) {
                Address.instance.api = Address.API_KEY_TOW
                callImdbList(artist)
            }

            override fun onResponse(call: Call<Imdb>, response: Response<Imdb>) =
                if (response.isSuccessful) {
                    val imdb: Imdb = response.body()!!
                    when {
                        imdb.response -> {
                            setChanged()
                            notifyObservers(response.body())
                        }
                        else -> {}
                    }
                } else {
                    Address.instance.api = Address.API_KEY_TOW
                    callImdbList(artist)
                }
        })
    }

    fun callImdbInfoMovie(imdbID: String) {

        val call = api.getInfoFilm(Address.API_KEY_ONE, imdbID)
        call.enqueue(object : Callback<InfoMovie> {
            override fun onFailure(call: Call<InfoMovie>, t: Throwable) {
                Address.instance.api = Address.API_KEY_TOW
                callImdbInfoMovie(imdbID)
            }

            override fun onResponse(call: Call<InfoMovie>, response: Response<InfoMovie>) {
                if (response.isSuccessful) {
                    setChanged()
                    notifyObservers(response.body())
                } else {
                    Address.instance.api = Address.API_KEY_TOW
                    callImdbInfoMovie(imdbID)
                }
            }
        })
    }


}

