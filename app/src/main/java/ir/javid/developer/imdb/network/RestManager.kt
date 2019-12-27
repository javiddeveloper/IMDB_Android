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
class RestManager : Observable() {
    private val api = ApiClient().loadData()
    companion object {
        val instance: RestManager by lazy {
            RestManager()
        }
    }

    fun callImdbList(artist: String) {
        val list: MutableLiveData<Imdb> = MutableLiveData()
        val call = api.getImdbList(artist)
        call.enqueue(object : Callback<Imdb> {
            override fun onFailure(call: Call<Imdb>, t: Throwable) {
                list.value = null

            }

            override fun onResponse(call: Call<Imdb>, response: Response<Imdb>) {
                if (response.isSuccessful) {
                    setChanged()
                    notifyObservers(response.body())
                }
            }
        })
    }
    fun callImdbInfoMovie(imdbID: String) {
        val list: MutableLiveData<InfoMovie> = MutableLiveData()
        val call = api.getInfoFilm(imdbID)
        call.enqueue(object : Callback<InfoMovie> {
            override fun onFailure(call: Call<InfoMovie>, t: Throwable) {
                list.value = null

            }

            override fun onResponse(call: Call<InfoMovie>, response: Response<InfoMovie>) {
                if (response.isSuccessful) {
                    setChanged()
                    notifyObservers(response.body())
                }
            }
        })
    }

//    fun callWeatherByLatLang(lat: String, lang: String, tempUnit: String) {
//        val call = service.getForecastsByLocation(lat, lang, tempUnit, Auth.auth)
//        call.enqueue(object : Callback<Forecasts> {
//
//            override fun onFailure(call: Call<Forecasts>, t: Throwable) {
//                Log.d("ds", t.message)
//            }
//
//            override fun onResponse(call: Call<Forecasts>, response: Response<Forecasts>) {
//                if (response.isSuccessful) {
//                    val forecasts: Forecasts? = response.body()
//                    setChanged()
//                    notifyObservers(forecasts)
//                }
//            }
//        })
//    }

}

