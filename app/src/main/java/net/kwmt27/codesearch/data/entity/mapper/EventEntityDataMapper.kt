package net.kwmt27.codesearch.data.entity.mapper

import net.kwmt27.codesearch.data.entity.EventEntity
import net.kwmt27.codesearch.domain.model.EventModel
import net.kwmt27.codesearch.domain.model.valueobject.GithubUser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventEntityDataMapper @Inject constructor() {

    fun transform(events: List<EventEntity>) : List<EventModel> {
        return events.map { EventModel().apply {
            isPublic = true
            githubUser = GithubUser(it.actor.displayLogin)
        } }


    }
}