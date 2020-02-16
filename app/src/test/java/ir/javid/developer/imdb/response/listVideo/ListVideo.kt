package ir.javid.developer.imdb.response.listVideo

import ir.javid.developer.imdb.response.MockResponse
import ir.javid.developer.imdb.tools.ResponseUtil

/**
 * Developed by javid
 */
class ListVideo : MockResponse{

    override fun response(): okhttp3.mockwebserver.MockResponse {
        return okhttp3.mockwebserver.MockResponse()
            .setResponseCode(200)
            .setBody(
                ResponseUtil.readFileFromAssets(
                        ResponseUtil.ServerResponseFile.REQUEST_BUYINGPOWER_RESPONSE,
                        ResponseUtil.RESPONSE_TYPE.SUCCESS
                    )
            )
    }
}