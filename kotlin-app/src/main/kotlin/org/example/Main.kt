package org.example

/**
 * A simple to-do list manager demonstrating basic Kotlin features:
 * data classes, nullable types, collections, and string templates.
 */
data class Task(val id: Int, val description: String, val done: Boolean = false)

class TaskList {
    private val tasks = mutableListOf<Task>()
    private var nextId = 1

    fun add(description: String): Task {
        val task = Task(nextId++, description)
        tasks.add(task)
        return task
    }

    fun complete(id: Int): Task? {
        val index = tasks.indexOfFirst { it.id == id }
        if (index == -1) return null
        val updated = tasks[index].copy(done = true)
        tasks[index] = updated
        return updated
    }

    fun all(): List<Task> = tasks.toList()

    fun pending(): List<Task> = tasks.filter { !it.done }
}

fun main() {
    val list = TaskList()

    println("=== Kotlin To-Do App ===")

    list.add("Learn Kotlin basics")
    list.add("Write a small app")
    list.add("Run the tests")

    list.complete(1)

    println("\nAll tasks:")
    for (task in list.all()) {
        val status = if (task.done) "[x]" else "[ ]"
        println("  $status #${task.id} ${task.description}")
    }

    println("\nPending: ${list.pending().size} task(s)")
}
