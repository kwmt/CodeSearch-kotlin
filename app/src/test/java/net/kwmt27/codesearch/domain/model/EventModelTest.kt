package net.kwmt27.codesearch.domain.model

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class EventModelTest {

    lateinit var event: EventModel

    @Before
    fun setUp() {
        event = EventModel()
    }

    @Test
    fun testEventConstructor() {
        assertThat(event.itemType, `is`(ItemType.Normal))
    }
}