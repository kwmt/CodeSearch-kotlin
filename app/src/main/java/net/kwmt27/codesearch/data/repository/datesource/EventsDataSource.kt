package net.kwmt27.codesearch.data.repository.datesource

import io.reactivex.Single
import net.kwmt27.codesearch.data.entity.EventEntity


interface EventsDataSource {

    fun eventEntities(user:String, page:Int): Single<List<EventEntity>>
}