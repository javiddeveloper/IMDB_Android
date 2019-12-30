package ir.javid.developer.imdb.data.rest

import ir.javid.developer.imdb.data.rest.model.Address
import ir.javid.developer.imdb.data.rest.model.Imdb
import ir.javid.developer.imdb.data.rest.model.InfoMovie
import retrofit2.http.GET
//import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Query

/**
 * Developed by javid
 */
interface Api {

    // get imdb list
    @GET("${Address.BASE_URL}${Address.API_KEY}")
    fun getImdbList(@Query("s") artist: String): Call<Imdb>

    // get imdb list
    @GET("${Address.BASE_URL}${Address.API_KEY}")
    fun getInfoFilm(@Query("i") imdbID: String): Call<InfoMovie>


}
