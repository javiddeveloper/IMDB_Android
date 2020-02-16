package ir.javid.developer.imdb.tools

import ir.javid.developer.imdb.MockServer.MockApiServer
import org.junit.AfterClass
import org.junit.BeforeClass
import java.io.IOException
import java.security.NoSuchAlgorithmException

/**
 * Developed by javid
 */
 class MockServerRunner {
     companion object {
         var mockApiServer: MockApiServer? = null

        @BeforeClass
        fun startServer() {
            mockApiServer = MockApiServer.instance
            try {
                mockApiServer!!.startServer()
            } catch (e: IOException) {
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }

        }

        @AfterClass
        fun tearDown() {
            mockApiServer!!.stopServer()
        }
    }
}