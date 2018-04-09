package jp.famirich.app.presentation.service.push

import com.google.firebase.messaging.RemoteMessage
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import jp.famirich.app.domain.model.PushMessage
import jp.famirich.app.domain.usecase.NotifyPushMessageUseCase
import javax.inject.Inject

class FamirichPushViewModel @Inject constructor(
        private val compositeDisposable: CompositeDisposable,
        private val notifyPushMessageUseCase: NotifyPushMessageUseCase
) {

    /**
     * [remoteMessage]をパースして、プッシュメッセージを通知する
     * @param remoteMessage remoteMessage
     */
    fun notify(remoteMessage: RemoteMessage) {
        val message = remoteMessage.notification?.body ?: return
        val url = remoteMessage.data?.let {
            it["url"] ?: ""
        } ?: ""
        notifyPushMessageUseCase
                .execute(PushMessage(message, url))
                .subscribe()
                .addTo(compositeDisposable)
    }

    fun destroy() {
        compositeDisposable.clear()
    }
}