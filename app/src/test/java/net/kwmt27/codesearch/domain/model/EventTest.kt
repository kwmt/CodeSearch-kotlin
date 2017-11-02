package net.kwmt27.codesearch.domain.model

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EventTest {

    lateinit var event: Event

    @Before
    fun setUp() {
        event = Event()
    }

    @Test
    fun testEventConstructor() {
        assertEquals(event.itemType, ItemType.Normal)
    }
}
