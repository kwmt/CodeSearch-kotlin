package jp.famirich.app.domain.model

/**
 * プッシュメッセージ
 */
data class PushMessage(
        val message: String,
        val url: String
) {

    companion object {
        const val NOTIFICATION_ID = 1
        const val KEY_URL = "url"
    }
}
