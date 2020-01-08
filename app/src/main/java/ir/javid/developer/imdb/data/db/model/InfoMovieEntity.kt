package ir.javid.developer.imdb.data.db.model

import androidx.annotation.Nullable
import androidx.room.*

/**
 * Developed by javid
 */
@Entity(tableName = "tbl_info_movie")
data class InfoMovieEntity(
    var title: String,
    var year: String,
    var rated: String,
    var released: String,
    var runtime: String,
    var genre: String,
    var director: String,
    var writer: String,
    var actors: String,
    var plot: String,
    var language: String,
    var country: String,
    var awards: String,
    var poster: String,
    var metascore: String,
    var imdbRating: String,
    var imdbVotes: String,
    @PrimaryKey var imdbID: String,
    var type: String,
    var dVD: String,
    var boxOffice: String,
    var production: String,
    var website: String,
    var response: Boolean


    //    ral ratings                                                                          : List<RatingsEntity>,

)