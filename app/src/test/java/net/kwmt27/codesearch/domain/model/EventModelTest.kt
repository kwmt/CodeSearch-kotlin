package net.kwmt27.codesearch.domain.model

import org.junit.Assert.assertEquals
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
        assertEquals(event.itemType, ItemType.Normal)
    }
}