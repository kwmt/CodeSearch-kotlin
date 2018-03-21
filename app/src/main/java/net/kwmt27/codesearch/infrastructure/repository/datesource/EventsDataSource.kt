package net.kwmt27.codesearch.infrastructure.repository.datesource

import io.reactivex.Single
import net.kwmt27.codesearch.infrastructure.entity.EventEntity

interface EventsDataSource {

    fun eventEntities(user: String, page: Int): Single<List<EventEntity>>
}
