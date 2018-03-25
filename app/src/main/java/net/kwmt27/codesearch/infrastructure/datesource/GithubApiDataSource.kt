package net.kwmt27.codesearch.infrastructure.datesource

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import net.kwmt27.codesearch.domain.model.Event
import net.kwmt27.codesearch.domain.repository.EventListRepository
import net.kwmt27.codesearch.infrastructure.api.GithubApi
import net.kwmt27.codesearch.infrastructure.entity.mapper.EventEntityModelMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubApiDataSource @Inject constructor(
    private val githubApi: GithubApi,
    private val eventEntityModelMapper: EventEntityModelMapper
) : EventListRepository {

    /**
     * イベントリストを取得する
     */
    override fun fetchEventList(user: String, page: Int): Single<List<Event>> =
            githubApi.fetchEvent(user, page)
                    .map(eventEntityModelMapper::transform)
                    .subscribeOn(Schedulers.io())
}
