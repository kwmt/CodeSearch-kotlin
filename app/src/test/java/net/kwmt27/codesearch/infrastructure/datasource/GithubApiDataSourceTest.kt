package net.kwmt27.codesearch.infrastructure.datasource

import io.reactivex.Single
import net.kwmt27.codesearch.infrastructure.api.GithubApi
import net.kwmt27.codesearch.infrastructure.datesource.GithubApiDataSource
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
class GithubApiDataSourceTest {
    private lateinit var githubApiDataSource: GithubApiDataSource

    @Mock private lateinit var mockGithubApi: GithubApi
    private var mockEventEntityModelMapper = EventEntityModelMapper()

    val FAKE_USER_ID = "test"
    val FAKE_PAGE = 1

    @Before
    fun setup() {
        githubApiDataSource = GithubApiDataSource(mockGithubApi, mockEventEntityModelMapper)
    }

    @Test
    fun testGxetEventsSuccessCase() {
        val eventEntityList = arrayListOf<EventEntity>()
        eventEntityList.add(EventEntity())

        val eventList = mockEventEntityModelMapper.transform(eventEntityList)


        given(githubApiDataSource
                .fetchEventList(FAKE_USER_ID, FAKE_PAGE)
        ).willReturn(Single.just(eventList))

        githubApiDataSource.fetchEventList(FAKE_USER_ID, FAKE_PAGE)

        verify(mockGithubApi).fetchEvent(FAKE_USER_ID, FAKE_PAGE)
    }
}

