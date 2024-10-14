package app.todolist.presentation.screen.share

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.todolist.ui.component.AppDrawer
import app.todolist.ui.navigation.NavigationActions
import app.todolist.ui.theme.LocalColorScheme
import kotlinx.coroutines.Job

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShareScreen(
    navigationActions: NavigationActions,
    drawerState: DrawerState,
    currentRoute: String,
    closeDrawer: () -> Job,

    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(currentRoute = currentRoute,
                navigateToReminder = navigationActions.navigateToReminder,
                navigateToTrash = navigationActions.navigateToTrash,
                closeDrawer = { closeDrawer() }
            )
        },
    ) {
        Surface(
            modifier = Modifier
                .background(color = LocalColorScheme.current.primaryBackgroundColor)
                .systemBarsPadding()
                .padding(start = 5.dp)
        ) {
            content()
        }
    }
}