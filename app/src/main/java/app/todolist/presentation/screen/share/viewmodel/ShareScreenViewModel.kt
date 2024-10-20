package app.todolist.presentation.screen.share.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.todolist.infrastructure.repositories.TodoRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShareScreenViewModel @Inject constructor(
    private val todoRepositoryImpl: TodoRepositoryImpl
) : ViewModel() {
    private val _uiState = MutableStateFlow(UIState.default)
    val uiState = _uiState.asStateFlow()
    private var state: UIState
        get() = _uiState.value
        set(value) {
            _uiState.update { value }
        }

    init {
        viewModelScope.launch {
            launch {
                todoRepositoryImpl.getCountAllUnfinishedTodo().collect { unfinishedCount ->
                    state = state.copy(unfinishedTodoCount = unfinishedCount)
                }
            }

            launch {
                todoRepositoryImpl.getCountAllFinishedTodo().collect { finishedCount ->
                    state = state.copy(finishedTodoCount = finishedCount)
                }
            }

            launch {
                todoRepositoryImpl.getCountAllDeletedTodo().collect { deletedCount ->
                    state = state.copy(deleteTodoCount = deletedCount)
                }
            }
        }
    }
}
