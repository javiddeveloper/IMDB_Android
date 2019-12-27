package ir.javid.developer.imdb.model

import com.google.gson.annotations.SerializedName

data class Imdb(
    @SerializedName("Search") val search : List<Search>,
    @SerializedName("totalResults") val totalResults : Int,
    @SerializedName("Response") val response : Boolean
)
