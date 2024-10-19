package app.todolist.presentation.screen.edit

import androidx.compose.runtime.Composable
import app.todolist.presentation.screen.edit.components.EditScreen

@Composable
fun EditRoute(
    todoId: String?,
    isCurrentTrashRoute: Boolean = false,
    isCurrentCompleteRoute: Boolean = false,
    navigateToTodo: () -> Unit,
    navigateToTrash: () -> Unit,
    navigateToComplete: () -> Unit,
    navigateToEditDetails: (todoId: String?) -> Unit
) {
    EditScreen(
        todoId = todoId,
        isCurrentTrashRoute = isCurrentTrashRoute,
        isCurrentCompleteRoute = isCurrentCompleteRoute,
        navigateToTodo = navigateToTodo,
        navigateToTrash = navigateToTrash,
        navigateToComplete = navigateToComplete,
        navigateToEditDetails = navigateToEditDetails
    )
}
