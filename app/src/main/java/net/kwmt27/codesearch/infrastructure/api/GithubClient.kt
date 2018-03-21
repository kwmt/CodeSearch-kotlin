package net.kwmt27.codesearch.infrastructure.api

import io.reactivex.Single
import net.kwmt27.codesearch.infrastructure.entity.EventEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubClient @Inject
constructor(private val githubApi: GithubApi) {

    fun fetchEvent(user: String, page: Int): Single<List<EventEntity>> {
        return githubApi.fetchEvent(user, page)
    }
}
