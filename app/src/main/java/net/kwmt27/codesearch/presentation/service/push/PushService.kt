package net.kwmt27.codesearch.presentation.service.push

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

/**
 *
 */

class PushService : FirebaseMessagingService() {

    @Inject
    lateinit var viewModel: PushViewModel

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }

    override fun onDestroy() {
        viewModel.destroy()
        super.onDestroy()
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Timber.d("onMessageReceived:$remoteMessage")
         viewModel.notify(remoteMessage)
    }
}