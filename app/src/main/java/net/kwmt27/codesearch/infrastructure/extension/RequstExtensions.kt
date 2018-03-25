package net.kwmt27.codesearch.infrastructure.extension

import okhttp3.Request
import okhttp3.RequestBody
import okio.Buffer
import java.io.IOException

/**
 * @param cookies クッキー文字列
 * @return [Request] からcurl形式の文字列を返す
 */
fun Request.curl(cookies: String? = null): String {
    val body = this.body()
    val bodyString = body?.let { toStringFromRequestBody(it) } ?: ""
    val contentType = body?.contentType()?.toString() ?: ""
    val headersString = StringBuilder().apply {
        val headers = this@curl.headers()
        for (i in 0 until headers.size()) {
            this.append(" -H '" + headers.name(i)).append(": ").append(headers.value(i) + "'")
        }
        cookies?.let {
            this.append(" -H 'Cookie: $it'")
        }
    }.toString()
    return "curl  -X ${this.method()} \\\n -d '$bodyString' \\\n -H '$contentType'$headersString \\\n '${this.url()}'\n"
}

private fun toStringFromRequestBody(body: RequestBody): String {
    try {
        val buffer = Buffer()
        body.writeTo(buffer)
        return buffer.readUtf8()
    } catch (e: IOException) {
        return ""
    }
}
