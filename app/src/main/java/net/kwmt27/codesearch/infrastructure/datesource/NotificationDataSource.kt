package jp.famirich.app.infrastructure.datasource

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.app.TaskStackBuilder
import android.support.v4.content.ContextCompat
import com.jakewharton.rxrelay2.BehaviorRelay
import jp.famirich.app.R
import jp.famirich.app.application.App
import jp.famirich.app.domain.model.PushMessage
import jp.famirich.app.domain.repository.NotificationRepository
import jp.famirich.app.presentation.main.MainActivity
import jp.famirich.app.presentation.splash.SplashActivity
import javax.inject.Inject

class NotificationDataSource @Inject constructor(
        private val context: Context
) : NotificationRepository {

    override fun notify(pushMessage: PushMessage): BehaviorRelay<Boolean> {
        val appName = context.getString(R.string.app_name)

        val builder = NotificationCompat.Builder(context, context.getString(R.string.default_notification_channel_id))
                .setContentTitle(appName)
                .setSmallIcon(R.drawable.ic_notification)
                .setLargeIcon((ContextCompat.getDrawable(context, R.mipmap.ic_launcher_round) as BitmapDrawable).bitmap)
                .setColor(ContextCompat.getColor(context, R.color.notificationBackgroundColor)) // TODO:正式版のカラーに変更すること
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true) // タップするとキャンセル(消える)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentText(pushMessage.message)
                .setWhen(System.currentTimeMillis())
                .setShowWhen(true)

        val relay = BehaviorRelay.createDefault(false)

        val intent = createIntent(context)?.apply {
            if (!pushMessage.url.isEmpty()) {
                data = Uri.parse(pushMessage.url)
                putExtra(PushMessage.KEY_URL, pushMessage.url)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }
        } ?: return relay
        val pi = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        builder.setFullScreenIntent(pi, true)
                .setContentIntent(pi)

        val bigTextStyle = NotificationCompat.BigTextStyle(builder)
                .setBigContentTitle(appName)
                .bigText(pushMessage.message)
        NotificationManagerCompat.from(context).notify(PushMessage.NOTIFICATION_ID, bigTextStyle.build())
        relay.accept(true)
        return relay
    }

    private fun createIntent(context: Context): Intent? {
        val app = context as? App ?: return null
        val intent: Intent
        if (app.isActivityVisible) {
            intent = MainActivity.createIntent(context)
        } else {
            intent = Intent(context, SplashActivity::class.java)
            TaskStackBuilder.create(context).apply {
                addParentStack(SplashActivity::class.java)
                addNextIntent(intent)
            }
        }
        return intent
    }
}