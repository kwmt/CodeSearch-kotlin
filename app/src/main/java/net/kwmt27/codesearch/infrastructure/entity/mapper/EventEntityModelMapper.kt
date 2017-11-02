package net.kwmt27.codesearch.infrastructure.entity.mapper

import net.kwmt27.codesearch.domain.model.Event
import net.kwmt27.codesearch.domain.model.GithubUser
import net.kwmt27.codesearch.infrastructure.entity.EventEntity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * [EventEntity](net.kwmt27.codesearch.data.entity.EventEntity)から[Event](net.kwmt27.codesearch.domain.model.Event)に変換する
 */
@Singleton
class EventEntityModelMapper @Inject constructor() {

    fun transform(events: List<EventEntity>) : List<Event> {
        return events.map { Event().apply {
            isPublic = true
            githubUser = GithubUser(it.actor.displayLogin, it.actor.avatarUrl)
        } }


    }
}
