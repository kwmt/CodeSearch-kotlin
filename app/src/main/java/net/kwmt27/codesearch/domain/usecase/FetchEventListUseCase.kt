package net.kwmt27.codesearch.domain.usecase

import io.reactivex.Single
import net.kwmt27.codesearch.domain.model.Event
import net.kwmt27.codesearch.domain.repository.EventListRepository
import javax.inject.Inject

/**
 * イベントリストを取得するUseCase
 */
class FetchEventListUseCase @Inject constructor(
    private val eventRepository: EventListRepository
) : UseCase<FetchEventListUseCase.Companion.Params, List<Event>>() {

    companion object {
        data class Params(val user: String, val page: Int)
    }

    override fun buildRepository(param: Params): Single<List<Event>> {
        return eventRepository.fetchEventList(param.user, param.page)
    }
}
