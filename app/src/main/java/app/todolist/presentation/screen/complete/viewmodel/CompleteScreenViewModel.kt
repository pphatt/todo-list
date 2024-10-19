package app.todolist.presentation.screen.complete.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.todolist.domain.todo.entity.Todo
import app.todolist.infrastructure.repositories.TodoRepositoryImpl
import app.todolist.presentation.request.RestoreCompleteTodoDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompleteScreenViewModel @Inject constructor(
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
            is ViewAction.RestoreCompleteTodo -> onRestoreCompleteTodo(action.body)
        }
    }

    init {
        viewModelScope.launch {
            todoRepositoryImpl.getAllTodo().collect { todoList ->
                initializeTodo(todoList.filter { todo -> todo.completedAt != null && todo.deletedAt == null })
            }
        }
    }

    private fun initializeTodo(todo: List<Todo>) {
        state = state.copy(list = todo)
    }

    private fun onRestoreCompleteTodo(body: RestoreCompleteTodoDto) {
        viewModelScope.launch {
            todoRepositoryImpl.restoreCompleteTodo(body)
        }
    }
}
