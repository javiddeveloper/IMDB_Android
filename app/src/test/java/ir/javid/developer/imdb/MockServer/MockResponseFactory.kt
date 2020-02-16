package ir.javid.developer.imdb.MockServer

import ir.javid.developer.imdb.response.listVideo.ListVideo
import okhttp3.mockwebserver.MockResponse

/**
 * Developed by javid
 */
class MockResponseFactory {
    companion object {
        fun getResponse(requestPath: String): MockResponse {
            when (requestPath) {
                TestConstants.QUERY_LIST -> return MockResponse()
                else -> throw IllegalStateException("no mock set up for $requestPath")
            }
        }
    }
}