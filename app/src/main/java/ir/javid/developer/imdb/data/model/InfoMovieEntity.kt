package ir.javid.developer.imdb.data.model

import androidx.room.*

/**
 * Developed by javid
 */
@Entity(tableName = "tbl_info_movie")
data class InfoMovieEntity(
    @PrimaryKey @ColumnInfo(name = "infoId") var id: Int,
    val title: String,
    val year: String,
    val rated: String,
    val released: String,
    val runtime: String,
    val genre: String,
    val director: String,
    val writer: String,
    val actors: String,
    val plot: String,
    val language: String,
    val country: String,
    val awards: String,
    val poster: String,
//    val ratings: List<RatingsEntity>,
    val metascore: String,
    val imdbRating: String,
    val imdbVotes: String,
    val imdbID: String,
    val type: String,
    val dVD: String,
    val boxOffice: String,
    val production: String,
    val website: String,
    val response: Boolean
)