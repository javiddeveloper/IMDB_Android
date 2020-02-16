package ir.javid.developer.imdb.MockServer

import android.util.Log
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockWebServer
import java.io.IOException
import java.security.NoSuchAlgorithmException


/**
 * Developed by javid
 */
class MockApiServer {

     val mServer: MockWebServer

     val dispatcher: Dispatcher
        get() = DispatcherFactory.getDispatcher()

    init {
        mServer = MockWebServer()
        mServer.dispatcher = dispatcher
    }

    @Throws(IOException::class, NoSuchAlgorithmException::class)
    fun startServer() {
        try {
            mServer.start(MOCK_WEBSERVER_PORT)
        } catch (e: IOException) {
            throw IllegalStateException("mock server start issue", e)
        }

    }

    fun stopServer() {
        try {
            mServer.shutdown()
        } catch (e: IOException) {
            Log.v("Error mock server", "stop server failed")
        }

    }

    fun getmServer(): MockWebServer {
        return mServer
    }

    companion object {
         var instance: MockApiServer? = MockApiServer()
        val MOCK_WEBSERVER_PORT = 8000

//        fun getInstance(): MockApiServer {
//            //        if (instance == null) {
//            instance = MockApiServer()
//            //        }
//            return instance as MockApiServer
//        }
    }
}