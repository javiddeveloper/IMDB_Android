package ir.javid.developer.imdb.data.rest

import io.reactivex.Observable
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
    @GET(Address.BASE_URL)
    fun getImdbList(@Query("apikey") apikey: String, @Query("s") artist: String): Observable<Imdb>

    // get imdb list
    @GET(Address.BASE_URL)
    fun getInfoFilm(@Query("apikey") apikey: String, @Query("i") imdbID: String): Observable<InfoMovie>


}
