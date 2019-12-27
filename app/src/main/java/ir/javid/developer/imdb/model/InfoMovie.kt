package ir.javid.developer.imdb.model

data class InfoMovie(

    val title : String,
    val year : Int,
    val rated : String,
    val released : String,
    val runtime : String,
    val genre : String,
    val director : String,
    val writer : String,
    val actors : String,
    val plot : String,
    val language : String,
    val country : String,
    val awards : String,
    val poster : String,
    val ratings : List<Ratings>,
    val metascore : Int,
    val imdbRating : Double,
    val imdbVotes : String,
    val imdbID : String,
    val type : String,
    val dVD : String,
    val boxOffice : String,
    val production : String,
    val website : String,
    val response : Boolean
)