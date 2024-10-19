package app.todolist.presentation.screen.edit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.todolist.infrastructure.repositories.TodoRepositoryImpl
import app.todolist.presentation.request.RestoreCompleteTodoDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class EditScreenViewModel @Inject constructor(
    private val todoRepositoryImpl: TodoRepositoryImpl
) : ViewModel() {
    private val _uiState = MutableStateFlow(UIState.default)
    val uiState = _uiState.asStateFlow()
    private var state: UIState
        get() = _uiState.value
        set(value) {
            _uiState.update { value }
        }

    fun execute(action: ViewAction) {
        when (action) {
            is ViewAction.SetTodo -> getTodoById(
                id = action.id
            )

            is ViewAction.MoveTodoToTrash -> moveTodoToTrash()

            is ViewAction.DeleteTodo -> deleteTodo(action.todoId)

            is ViewAction.RestoreTodo -> restoreTodo(action.todoId)

            is ViewAction.RestoreCompleteTodo -> restoreCompleteTodo(action.body)
        }
    }

    private fun getTodoById(id: UUID) {
        viewModelScope.launch {
            todoRepositoryImpl.getAllTodo().collect { todoList ->
                val todo = todoList.find { todo -> todo.id == id }

                state = state.copy(todo = todo)
            }
        }
    }

    private fun moveTodoToTrash() {
        viewModelScope.launch {
            state.todo?.let { todoRepositoryImpl.moveTodoToTrash(it) }
        }
    }

    private fun deleteTodo(todoId: String) {
        viewModelScope.launch {
            todoRepositoryImpl.deleteTodo(todoId)
        }
    }

    private fun restoreTodo(todoId: String) {
        viewModelScope.launch {
            todoRepositoryImpl.restoreTodo(todoId)
        }
    }

    private fun restoreCompleteTodo(body: RestoreCompleteTodoDto) {
        viewModelScope.launch {
            todoRepositoryImpl.restoreCompleteTodo(body)
        }
    }
}