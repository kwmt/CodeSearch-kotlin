package net.kwmt27.codesearch.domain.model

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class EventModelTest {

    private val FAKE_TYPE = ItemType.valueOf(1)

    lateinit var event: EventModel

    @Before
    fun setUp() {
        event = EventModel(FAKE_TYPE)
    }

    @Test
    fun testEventConstructor() {
        val type = event.type
        assertThat(type, `is`(ItemType.Progress))
    }
}