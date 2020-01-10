package ir.javid.developer.imdb.data.rest

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import ir.javid.developer.imdb.data.rest.model.Address.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


/**
 * Developed by javid
 */
class ApiClient {

    fun client():OkHttpClient{
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder().build()
            chain.proceed(request)
        }
//            .connectTimeout(2000, TimeUnit.SECONDS)
//            .writeTimeout(2000, TimeUnit.SECONDS)
//            .readTimeout(3000, TimeUnit.SECONDS)


        return httpClient.build()
    }

    fun loadData(): Api {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(Api::class.java)
    }
}
