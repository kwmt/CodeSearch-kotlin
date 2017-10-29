package net.kwmt27.codesearch.infrastructure.entity.mapper

import net.kwmt27.codesearch.infrastructure.entity.EventEntity
import net.kwmt27.codesearch.domain.model.EventModel
import net.kwmt27.codesearch.domain.model.valueobject.GithubUser
import javax.inject.Inject
import javax.inject.Singleton

/**
 * [EventEntity](net.kwmt27.codesearch.data.entity.EventEntity)から[EvnetModel](net.kwmt27.codesearch.domain.model.EvnetModel)に変換する
 */
@Singleton
class EventEntityModelMapper @Inject constructor() {

    fun transform(events: List<EventEntity>) : List<EventModel> {
        return events.map { EventModel().apply {
            isPublic = true
            githubUser = GithubUser(it.actor.displayLogin, it.actor.avatarUrl)
        } }


    }
}
