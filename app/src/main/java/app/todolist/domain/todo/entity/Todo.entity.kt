package app.todolist.domain.todo.entity

import java.sql.Timestamp
import java.util.UUID

data class Todo(
    val id: UUID = UUID.randomUUID(),
    val content: String,
    val dueDate: Long? = null,
    val status: Boolean = false,
    val completedAt: Long? = null,
    val createdAt: Timestamp = Timestamp(System.currentTimeMillis()),
    val deletedAt: Timestamp? = null
)

class InvalidNoteException(message: String) : Exception(message)
