package ir.javid.developer.imdb.MockServer

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.RecordedRequest

/**
 * Developed by javid
 */
class DispatcherFactory {
    companion object {
        fun getDispatcher(): Dispatcher {
            return object : Dispatcher() {
                @Throws(InterruptedException::class)
                override fun dispatch(request: RecordedRequest): okhttp3.mockwebserver.MockResponse {
                    return MockResponseFactory.getResponse(request.requestUrl!!.query!!)
                }
            }
        }
    }
}