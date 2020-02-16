package ir.javid.developer.imdb.tools

import java.io.File
import java.io.IOException

/**
 * Developed by javid
 */
class ResponseUtil {
    companion object {
        fun readFileFromAssets(fileName: String, responseType: RESPONSE_TYPE): String {
            try {
                val `is` = ContextModel.context!!.classLoader
                    .getResourceAsStream(filePathGenerator(fileName, responseType))
                val size = `is`.available()
                val buffer = ByteArray(size)
                `is`.read(buffer)
                `is`.close()
                return String(buffer)
            } catch (e: IOException) {
                throw RuntimeException(e)
            } catch (e: Exception) {
                throw e
            }

        }
        private fun filePathGenerator(fileName: String, responseType: RESPONSE_TYPE): String {
            val baseFolder = "assets/test/"
            var responseTypeFolder = "success"
            when (responseType) {
                ResponseUtil.RESPONSE_TYPE.SUCCESS -> responseTypeFolder = "success"
                ResponseUtil.RESPONSE_TYPE.REST_ERROR -> responseTypeFolder = "restError"

                ResponseUtil.RESPONSE_TYPE.NETWORK_ERROR -> responseTypeFolder = "networkError"
            }

            return baseFolder + responseTypeFolder + File.separator + fileName

        }

    }



    enum class RESPONSE_TYPE {
        SUCCESS, REST_ERROR, NETWORK_ERROR
    }

    interface ServerResponseFile {
        companion object {
            val REQUEST_BUYINGPOWER_RESPONSE = "Request_BuyingPower_Response"
        }
    }
}