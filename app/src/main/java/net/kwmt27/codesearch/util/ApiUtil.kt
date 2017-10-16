package net.kwmt27.codesearch.util

import okhttp3.Request
import okhttp3.RequestBody
import okio.Buffer
import timber.log.Timber
import java.io.IOException

/**
 * API専用ユーティリティ
 */
object ApiUtil {

    /**
     * [Request] からcurl形式でログ出力する。
     * @param request [Request]
     */
    fun printCurlString(request: Request) {
        val url = request.url().toString()
        val method = request.method()
        var bodyString: String? = ""
        var contentType = ""
        if (request.body() != null) {
            bodyString = ApiUtil.toStringFromRequestBody(request.body())
            contentType = request.body()!!.contentType()!!.toString()
        }
        val headers = request.headers()
        val result = StringBuilder()
        for (i in 0 until headers.size()) {
            result.append(" -H '" + headers.name(i)).append(": ").append(headers.value(i) + "'")
        }
        val headersString = result.toString()
        Timber.d("curl  -X $method \\\n -d '$bodyString' \\\n -H '$contentType'$headersString \\\n '$url'\n")
    }

    private fun toStringFromRequestBody(body: RequestBody?): String? {
        if (body == null) {
            return null
        }
        try {
            val buffer = Buffer()
            body.writeTo(buffer)
            return buffer.readUtf8()
        } catch (e: IOException) {
            return null
        }

    }
}