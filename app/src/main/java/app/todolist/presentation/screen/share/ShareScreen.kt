package app.todolist.presentation.screen.share

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import app.todolist.presentation.screen.share.viewmodel.ShareScreenViewModel
import app.todolist.ui.component.AppDrawer
import app.todolist.ui.navigation.NavigationActions
import app.todolist.ui.theme.LocalColorScheme
import kotlinx.coroutines.Job

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShareScreen(
    viewModel: ShareScreenViewModel = hiltViewModel(),

    navigationActions: NavigationActions,
    drawerState: DrawerState,
    currentRoute: String,
    closeDrawer: () -> Job,

    content: @Composable () -> Unit
) {
    val state = viewModel.uiState.collectAsState().value

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                currentRoute = currentRoute,
                navigateToTodo = navigationActions.navigateToTodo,
                navigateToTrash = navigationActions.navigateToTrash,
                navigateToComplete = navigationActions.navigateToComplete,
                closeDrawer = { closeDrawer() },

                unfinishedTodoCount = state.unfinishedTodoCount,
                finishedTodoCount = state.finishedTodoCount,
                deleteTodoCount = state.deleteTodoCount,
            )
        },
    ) {
        Surface(
            modifier = Modifier
                .background(color = LocalColorScheme.current.primaryBackgroundColor)
                .systemBarsPadding()
        ) {
            content()
        }
    }
}
