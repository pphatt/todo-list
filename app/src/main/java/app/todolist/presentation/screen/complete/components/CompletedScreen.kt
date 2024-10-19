package app.todolist.presentation.screen.complete.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.todolist.presentation.screen.complete.viewmodel.CompleteScreenViewModel
import app.todolist.presentation.screen.complete.viewmodel.ViewAction
import app.todolist.ui.theme.LocalColorScheme
import app.todolist.utils.convertMillisToDate
import kotlinx.coroutines.Job

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CompletedScreen(
    viewModel: CompleteScreenViewModel = hiltViewModel(),
    openDrawer: () -> Job,
    onEditTodoClick: (String) -> Unit
) {
    val state = viewModel.uiState.collectAsState().value

    Scaffold(
        containerColor = LocalColorScheme.current.primaryBackgroundColor,
        modifier = Modifier
            .fillMaxSize()
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
                        text = "Completed Todo",
                        modifier = Modifier.weight(0.8f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    modifier = Modifier.padding(
                        start = 25.dp,
                        top = 5.dp,
                        end = 25.dp,
                        bottom = 20.dp
                    ),
                    text = "Completed todo will be displayed here."
                )

                val groupedTodoList = state.list
                    .sortedBy { it.completedAt }
                    .groupBy { convertMillisToDate(it.completedAt!!) }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(15.dp)),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    groupedTodoList.forEach { (date, todoList) ->
                        item {
                            CompleteList(
                                date = date,
                                todos = todoList,
                                onTodoClick = onEditTodoClick,
                                onRestoreCompleteTodo = {
                                    viewModel.execute(
                                        ViewAction.RestoreCompleteTodo(
                                            it
                                        )
                                    )
                                }
                            )
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
        }
    }
}
