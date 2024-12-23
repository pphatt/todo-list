package app.todolist.presentation.request

import java.sql.Timestamp
import java.util.UUID

data class EditTodoDto(
    val id: UUID,
    val content: String,
    val dueDate: Long?,
    val createdAt: Timestamp
)
