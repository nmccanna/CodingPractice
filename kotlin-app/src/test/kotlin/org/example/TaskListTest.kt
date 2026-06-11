package org.example

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class TaskListTest {
    @Test
    fun `add assigns incrementing ids`() {
        val list = TaskList()
        val first = list.add("first")
        val second = list.add("second")
        assertEquals(1, first.id)
        assertEquals(2, second.id)
    }

    @Test
    fun `complete marks task as done`() {
        val list = TaskList()
        list.add("task")
        val completed = list.complete(1)
        assertTrue(completed!!.done)
        assertEquals(0, list.pending().size)
    }

    @Test
    fun `complete returns null for unknown id`() {
        val list = TaskList()
        assertNull(list.complete(99))
    }

    @Test
    fun `pending excludes completed tasks`() {
        val list = TaskList()
        list.add("a")
        list.add("b")
        list.complete(1)
        assertEquals(listOf("b"), list.pending().map { it.description })
    }
}
