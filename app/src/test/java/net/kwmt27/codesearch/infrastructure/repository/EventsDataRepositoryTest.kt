package net.kwmt27.codesearch.infrastructure.repository

import io.reactivex.Single
import net.kwmt27.codesearch.infrastructure.entity.EventEntity
import net.kwmt27.codesearch.infrastructure.entity.mapper.EventEntityModelMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EventsDataRepositoryTest {
    private lateinit var eventsDataRepository: EventListDataSource

    @Mock private lateinit var mockEventsDataSourceManager: EventsDataSourceManager
    @Mock private lateinit var mockEventEntityModelMapper: EventEntityModelMapper

    val FAKE_USER_ID = "test"
    val FAKE_PAGE = 1

    @Before
    fun setup() {
        eventsDataRepository = EventListDataSource(mockEventsDataSourceManager, mockEventEntityModelMapper)

    }

    @Test
    fun testGxetEventsSuccessCase() {
        val events = arrayListOf<EventEntity>().apply {
            add(EventEntity())
        }


        given(mockEventsDataSourceManager.eventEntities(FAKE_USER_ID, FAKE_PAGE)).willReturn(Single.just(events))

        eventsDataRepository.fetchEventList(FAKE_USER_ID, FAKE_PAGE)

        verify(mockEventsDataSourceManager).eventEntities(FAKE_USER_ID, FAKE_PAGE)
    }
}

