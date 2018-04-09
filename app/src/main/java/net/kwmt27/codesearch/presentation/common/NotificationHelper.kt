package net.kwmt27.codesearch.presentation.common

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.annotation.StringRes
import net.kwmt27.codesearch.R

/**
 *
 */

enum class NotificationChannelType(
    @StringRes val idRes: Int,
    @StringRes val nameRes: Int,
    val importance: Int
) {
    NEW_FEED(
            R.string.new_feed_notification_channel_id,
            R.string.notification_channel_name_new_feed,
            NotificationManager.IMPORTANCE_HIGH
    )
}

fun Context.initNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationChannelType.values().forEach(::createNotificationChannel)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun Context.createNotificationChannel(channelType: NotificationChannelType) {
    getSystemService(NotificationManager::class.java)?.createNotificationChannel(
            NotificationChannel(
            getString(channelType.idRes),
            getString(channelType.nameRes),
            channelType.importance
    ))
}