package net.kwmt27.codesearch.data.repository.datesource

import io.reactivex.Single
import net.kwmt27.codesearch.data.api.GithubClient
import net.kwmt27.codesearch.data.entity.EventEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventsRemoteDataSource @Inject constructor(private val githubClient: GithubClient):EventsDataSource {
    override fun eventEntities(user: String, page: Int): Single<List<EventEntity>> {
        return githubClient.fetchEvent(user,page)
    }


}