package app.todolist.presentation.screen.todo.viewmodel

import app.todolist.presentation.request.CompleteTodoDto

sealed interface ViewAction {
    data class CompleteTodo(val body: CompleteTodoDto) : ViewAction
}
