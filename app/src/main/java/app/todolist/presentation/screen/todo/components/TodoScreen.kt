package app.todolist.presentation.screen.todo.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.todolist.ui.theme.LocalColorScheme
import kotlinx.coroutines.Job
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.todolist.domain.todo.entity.Todo
import app.todolist.presentation.screen.todo.viewmodel.TodoScreenViewModel
import app.todolist.presentation.screen.todo.viewmodel.ViewAction
import app.todolist.utils.isSameDay
import java.util.Calendar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TodoScreen(
    viewModel: TodoScreenViewModel = hiltViewModel(),
    openDrawer: () -> Job,
    navigateToDetails: () -> Unit,
    temporalTodos: SnapshotStateList<Todo>?,
    onTodoClick: (Todo) -> Unit
) {
    val state = viewModel.uiState.collectAsState().value

    val context = LocalContext.current

    Scaffold(
        containerColor = LocalColorScheme.current.primaryBackgroundColor,
        modifier = Modifier
            .fillMaxSize()
            .imePadding(),
        floatingActionButton = {
            AddTodoButton(navigateToDetails = navigateToDetails)
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier.padding(
                    bottom = 10.dp
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, top = 25.dp, end = 5.dp, bottom = 15.dp)
                        .height(48.dp)
                        .background(Color.Transparent),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(5.dp))

                    IconButton(
                        onClick = { openDrawer() }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            tint = MaterialTheme.colorScheme.outline,
                            contentDescription = "",
                        )
                    }

                    Text(
                        text = "All Todo",
                        modifier = Modifier.weight(0.8f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                val currentTimeMillis = System.currentTimeMillis()
                val currentCalendar = Calendar.getInstance()

                val nonDeletedList = state.list.filter { todo -> todo.deletedAt == null && todo.completedAt == null }

                val todoListFilteredByPastDate = nonDeletedList.filter { todo ->
                    todo.dueDate != null && todo.dueDate < currentTimeMillis && isSameDay(
                        todo.dueDate,
                        currentCalendar.timeInMillis
                    ).not()
                }

                val todoListFilteredByCurrentDate = nonDeletedList.filter { todo ->
                    todo.dueDate != null && isSameDay(
                        todo.dueDate,
                        currentCalendar.timeInMillis
                    )
                }

                val todoListFilteredByFutureDate = nonDeletedList.filter { todo ->
                    todo.dueDate != null && todo.dueDate > currentTimeMillis && isSameDay(
                        todo.dueDate,
                        currentCalendar.timeInMillis
                    ).not()
                }

                val todoListFilteredByNoDate =
                    nonDeletedList.filter { todo -> todo.dueDate == null }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(15.dp)),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (todoListFilteredByPastDate.isNotEmpty()) {
                        item {
                            TodoList(
                                title = "Past date",
                                todos = todoListFilteredByPastDate,
                                temporalTodos = temporalTodos,
                                onTodoClick = onTodoClick,
                                onCompleteTodo = { viewModel.execute(ViewAction.CompleteTodo(it)) }
                            )
                        }
                    }

                    if (todoListFilteredByCurrentDate.isNotEmpty()) {
                        item {
                            TodoList(
                                title = "Current date",
                                todos = todoListFilteredByCurrentDate,
                                temporalTodos = temporalTodos,
                                onTodoClick = onTodoClick,
                                onCompleteTodo = { viewModel.execute(ViewAction.CompleteTodo(it)) }
                            )
                        }
                    }

                    if (todoListFilteredByFutureDate.isNotEmpty()) {
                        item {
                            TodoList(
                                title = "Future date",
                                todos = todoListFilteredByFutureDate,
                                temporalTodos = temporalTodos,
                                onTodoClick = onTodoClick,
                                onCompleteTodo = { viewModel.execute(ViewAction.CompleteTodo(it)) }
                            )
                        }
                    }

                    if (todoListFilteredByNoDate.isNotEmpty()) {
                        item {
                            TodoList(
                                title = "No date",
                                todos = todoListFilteredByNoDate,
                                temporalTodos = temporalTodos,
                                onTodoClick = onTodoClick,
                                onCompleteTodo = { viewModel.execute(ViewAction.CompleteTodo(it)) }
                            )
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }

                if (state.list.isNotEmpty()) {
                    val currentTime = System.currentTimeMillis()

                    val todoTimeMillis = state.list.last().createdAt.time

                    if (todoTimeMillis >= currentTime - 100) {
                        Toast.makeText(
                            context,
                            "Save todo successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}
