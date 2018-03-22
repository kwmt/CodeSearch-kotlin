package net.kwmt27.codesearch.presentation.eventlist

import android.databinding.BaseObservable
import android.view.View
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import net.kwmt27.codesearch.domain.model.GithubUser
import net.kwmt27.codesearch.presentation.common.ViewModel
import timber.log.Timber

/**
 * イベント一覧の各リストアイテムに対応するViewModel
 */
class EventViewModel(
    githubUser: GithubUser,
    private val eventListNavigator: EventListNavigator
) : BaseObservable(), ViewModel {

    private val compositeDisposable = CompositeDisposable()

    val name: String = githubUser.name
    val imageUrl: String = githubUser.imageUrl

    override fun destroy() {
        compositeDisposable.clear()
    }

    fun onClickEvent(@Suppress("UNUSED_PARAMETER") view: View) {
        eventListNavigator.startActivityForResultSample().subscribe({ result ->
            Timber.d(result)
        }, {
            Timber.w(it)
        }).addTo(compositeDisposable)
    }
}
