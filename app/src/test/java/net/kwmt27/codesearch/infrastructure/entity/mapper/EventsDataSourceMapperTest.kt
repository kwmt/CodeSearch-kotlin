package net.kwmt27.codesearch.infrastructure.entity.mapper

import net.kwmt27.codesearch.infrastructure.entity.ActorEntity
import net.kwmt27.codesearch.infrastructure.entity.EventEntity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EventsDataSourceMapperTest {

    companion object {
        const val FAKE_GITHUBUSER_DISPLAY_LOGIN = "testdisplaylogin"
    }


    private lateinit var eventsDataSourceMapper: EventEntityModelMapper

    @Before
    fun setup() {
        eventsDataSourceMapper = EventEntityModelMapper()
    }

    /**
     * List<EventEntity>からList<Event>への変換テスト
     */
    @Test
    fun testTransformEventModel() {
        val eventsModel = eventsDataSourceMapper.transform(createFakeEvents())

        assertEquals(eventsModel.size, 1)
        assertEquals(eventsModel.get(0).githubUser.name, FAKE_GITHUBUSER_DISPLAY_LOGIN)
        // TODO:その他のプロパティのテスト
    }

    private fun createFakeEvents(): List<EventEntity> {
        return arrayListOf<EventEntity>().apply {
            add(EventEntity().apply {
                id = "1"
                type = "event"
                public = true
                actor = ActorEntity().apply {
                    id = 2
                    login = "testlogin"
                    displayLogin = FAKE_GITHUBUSER_DISPLAY_LOGIN
                    gravatarId = "testgravatarid"
                    avatarUrl = "testavatarurl"
                }
            })
        }
    }
}
