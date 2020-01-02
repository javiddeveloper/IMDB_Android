package ir.javid.developer.imdb.data.rest.model

class Address {
    companion object {
        const val BASE_URL: String = "http://www.omdbapi.com/"
        const val API_KEY_ONE: String = "3e974fca"
        const val API_KEY_TOW: String = "db04ea89"
            val instance: Address by lazy {
                Address()
            }
    }
    var api: String = API_KEY_TOW

}