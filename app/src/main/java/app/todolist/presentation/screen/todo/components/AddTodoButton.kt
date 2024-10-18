package app.todolist.presentation.screen.todo.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import app.todolist.ui.theme.LocalColorScheme

@Composable
fun AddTodoButton(navigateToDetails: () -> Unit) {
    FloatingActionButton(
        onClick = { navigateToDetails() },
        shape = RoundedCornerShape(50),
        containerColor = LocalColorScheme.current.floatButtonBackgroundColor,
        contentColor = LocalColorScheme.current.addIconColor,
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Todo")
    }
}
