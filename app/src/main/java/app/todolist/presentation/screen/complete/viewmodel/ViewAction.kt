package app.todolist.presentation.screen.complete.viewmodel

import app.todolist.presentation.request.RestoreCompleteTodoDto

sealed interface ViewAction {
    data class RestoreCompleteTodo(val body: RestoreCompleteTodoDto) : ViewAction
}
