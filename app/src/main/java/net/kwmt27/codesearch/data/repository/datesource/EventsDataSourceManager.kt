package net.kwmt27.codesearch.data.repository.datesource

import io.reactivex.Single
import net.kwmt27.codesearch.data.entity.EventEntity
import javax.inject.Inject

class EventsDataSourceManager @Inject constructor(private val eventsRemoteDataSource: EventsRemoteDataSource) {

    fun eventEntities(user:String, page:Int): Single<List<EventEntity>> {
        // リモートかキャッシュを使うかの判断をココでやるとよさそう
        return eventsRemoteDataSource.eventEntities(user, page)
    }
}