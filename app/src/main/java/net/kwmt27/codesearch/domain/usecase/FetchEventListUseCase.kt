package net.kwmt27.codesearch.domain.usecase

import io.reactivex.Single
import net.kwmt27.codesearch.domain.model.Event
import net.kwmt27.codesearch.domain.repository.EventListRepository
import javax.inject.Inject

/**
 * イベントリストを取得するUseCase
 */
interface FetchEventListUseCase {
    fun execute(user: String, page: Int): Single<List<Event>>
}

class FetchEventListUseCaseImpl @Inject constructor(
    private val eventRepository: EventListRepository
) : FetchEventListUseCase {


    override fun execute(user: String, page: Int): Single<List<Event>> {
        return eventRepository.fetchEventList(user, page)
    }
}
