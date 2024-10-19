package app.todolist.presentation.screen.edit.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.RestartAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun AppBottomBarResume(
    modifier: Modifier = Modifier,
    onRestoreTodo: () -> Unit,
    onDeleteTodo: () -> Unit
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color.Transparent
    ) {
        NavigationBarItem(
            label = { Text("Restore", fontSize = 15.sp) },
            icon = {
                Icon(Icons.Rounded.RestartAlt, null)
            },
            selected = false,
            onClick = onRestoreTodo
        )
        NavigationBarItem(
            label = { Text("Delete", fontSize = 15.sp) },
            icon = {
                Icon(Icons.Rounded.Delete, null)
            },
            selected = false,
            onClick = onDeleteTodo
        )
    }
}