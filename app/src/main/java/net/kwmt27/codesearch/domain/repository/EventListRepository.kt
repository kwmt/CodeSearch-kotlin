package net.kwmt27.codesearch.domain.repository

import io.reactivex.Single
import net.kwmt27.codesearch.domain.model.Event

interface EventListRepository {
    /**
     * イベントリストを取得する
     *
     * @param user 誰のイベントリストを取得するかを指定する
     * @param page 何ページ目のイベントリストを取得するかを指定する
     * @return
     */
    fun fetchEventList(user: String, page: Int): Single<List<Event>>
}
