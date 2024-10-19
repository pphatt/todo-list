package app.todolist.presentation.request

import java.util.UUID

data class CompleteTodoDto(
    val id: UUID,
    val completedAt: Long,
)
