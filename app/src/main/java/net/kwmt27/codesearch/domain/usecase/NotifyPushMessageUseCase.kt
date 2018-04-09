package jp.famirich.app.domain.usecase

import com.jakewharton.rxrelay2.BehaviorRelay
import jp.famirich.app.domain.model.PushMessage
import jp.famirich.app.domain.repository.NotificationRepository
import javax.inject.Inject

/**
 * プッシュメッセージを通知するユースケース
 */
interface NotifyPushMessageUseCase {
    fun execute(pushMessage: PushMessage): BehaviorRelay<Boolean>
}

class NotifyPushMessageUseCaseImpl @Inject constructor(
        private val notificationRepository: NotificationRepository
) : NotifyPushMessageUseCase {

    override fun execute(pushMessage: PushMessage): BehaviorRelay<Boolean> {
        return notificationRepository.notify(pushMessage)
    }
}
