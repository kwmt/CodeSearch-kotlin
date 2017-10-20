package net.kwmt27.codesearch.domain.interactor

import io.reactivex.observers.DisposableSingleObserver


/**
 * エラーハンドリングはここでやる
 */
open class BaseObserver<T>: DisposableSingleObserver<T>() {
    override fun onSuccess(t: T) {
        // no-op
    }

    override fun onError(e: Throwable) {
        // no-op
    }
}