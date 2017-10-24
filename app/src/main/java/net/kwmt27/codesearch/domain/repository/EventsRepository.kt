package net.kwmt27.codesearch.domain.repository

import io.reactivex.Single
import net.kwmt27.codesearch.domain.model.EventModel

interface EventsRepository {
    /**
     * イベントリストを取得する
     *
     * [net.kwmt27.codesearch.data.entity.EventEntity]から[EventModel]に変換する
     * @param user 誰のイベントリストを取得するかを指定する
     * @param page 何ページ目のイベントリストを取得するかを指定する
     */
    fun events(user:String, page:Int) : Single<List<EventModel>>
}