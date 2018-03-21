package net.kwmt27.codesearch.presentation.eventlist

import android.databinding.BaseObservable
import android.view.View
import net.kwmt27.codesearch.domain.model.GithubUser
import net.kwmt27.codesearch.presentation.ViewModel

/**
 * イベント一覧の各リストアイテムに対応するViewModel
 */
class EventViewModel(githubUser: GithubUser) : BaseObservable(), ViewModel {

    val name: String = githubUser.name
    val imageUrl: String = githubUser.imageUrl

    override fun destroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onClickEvent(view: View) {
    }
}
