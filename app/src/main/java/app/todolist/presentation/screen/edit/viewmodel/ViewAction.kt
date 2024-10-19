package app.todolist.presentation.screen.edit.viewmodel

import app.todolist.presentation.request.RestoreCompleteTodoDto
import java.util.UUID

sealed interface ViewAction {
    data class SetTodo(val id: UUID) : ViewAction

    data object MoveTodoToTrash : ViewAction

    data class DeleteTodo(val todoId: String) : ViewAction

    data class RestoreTodo(val todoId: String) : ViewAction

    data class RestoreCompleteTodo(val body: RestoreCompleteTodoDto) : ViewAction
}
