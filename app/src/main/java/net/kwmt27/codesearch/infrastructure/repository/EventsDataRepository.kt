package net.kwmt27.codesearch.infrastructure.repository

import io.reactivex.Single
import net.kwmt27.codesearch.infrastructure.entity.mapper.EventEntityModelMapper
import net.kwmt27.codesearch.infrastructure.repository.datesource.EventsDataSourceManager
import net.kwmt27.codesearch.domain.model.EventModel
import net.kwmt27.codesearch.domain.repository.EventsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventsDataRepository
@Inject constructor(private val eventsDataSourceManager: EventsDataSourceManager, private val eventEntityModelMapper: EventEntityModelMapper) : EventsRepository {



    override fun events(user:String, page:Int): Single<List<EventModel>> {
        return eventsDataSourceManager.eventEntities(user, page).map{ eventEntityModelMapper.transform(it)}
    }
}
