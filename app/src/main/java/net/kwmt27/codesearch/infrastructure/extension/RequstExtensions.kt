package net.kwmt27.codesearch.infrastructure.extension

import okhttp3.Request
import okhttp3.RequestBody
import okio.Buffer
import timber.log.Timber
import java.io.IOException

/**
 * [Request] からcurl形式でログ出力する。
 * @param request [Request]
 */
inline fun Request.printCurlString() {
    val bodyString = body()?.toStringFromRequestBody() ?: ""
    val contentType = body()?.contentType()?.toString() ?: ""

    val headers = headers()
    val result = StringBuilder()

    if (headers.size() > 0) {
        for (i in 0..headers.size()) {
            result.append(" -H '" + headers.name(i)).append(": ").append(headers.value(i) + "'")
        }
    }
    Timber.d("curl  -X ${method()} \\\n -d '$bodyString' \\\n -H '$contentType'$result \\\n '${url()}'\n")
}

inline fun RequestBody.toStringFromRequestBody(): String {
    try {
        val buffer = Buffer()
        writeTo(buffer)
        return buffer.readUtf8()
    } catch (e: IOException) {
        return ""
    }
}

