package app.todolist.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckBox
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.CollectionsBookmark
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.LibraryAddCheck
import androidx.compose.material.icons.rounded.LibraryBooks
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import app.reminder.presentation.core.components.material.NavigationDrawerItem
import app.todolist.R
import app.todolist.ui.navigation.Tabs
import app.todolist.ui.theme.LocalColorScheme

@Composable
fun AppDrawer(
    currentRoute: String,
    modifier: Modifier = Modifier,
    navigateToTodo: () -> Unit,
    navigateToComplete: () -> Unit,
    navigateToTrash: () -> Unit,
    closeDrawer: () -> Unit,

    unfinishedTodoCount: Int,
    finishedTodoCount: Int,
    deleteTodoCount: Int,
) {
    ModalDrawerSheet(
        modifier.statusBarsPadding(),
        drawerContainerColor = LocalColorScheme.current.backgroundColor
    ) {
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Text(
            "Personal Todo",
            modifier = Modifier.padding(
                start = 15.dp + 6.dp,
                top = 15.dp,
                end = 15.dp,
                bottom = 15.dp
            ),
            color = LocalColorScheme.current.foregroundColor,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        HorizontalDivider(
            modifier = Modifier
                .padding(
                    start = NavigationDrawerItemDefaults.ItemPadding.calculateStartPadding(
                        LayoutDirection.Ltr
                    ) + 8.dp,
                    top = NavigationDrawerItemDefaults.ItemPadding.calculateTopPadding(),
                    end = NavigationDrawerItemDefaults.ItemPadding.calculateEndPadding(
                        LayoutDirection.Rtl
                    ) + 8.dp,
                    bottom = 10.dp,
                ),
            color = LocalColorScheme.current.activeForegroundColor
        )
        NavigationDrawerItem(
            modifier = Modifier.padding(
                start = NavigationDrawerItemDefaults.ItemPadding.calculateStartPadding(
                    LayoutDirection.Ltr
                ),
                top = NavigationDrawerItemDefaults.ItemPadding.calculateTopPadding(),
                end = NavigationDrawerItemDefaults.ItemPadding.calculateEndPadding(LayoutDirection.Rtl),
                bottom = NavigationDrawerItemDefaults.ItemPadding.calculateBottomPadding(),
            ),
            label = {
                Text(
                    stringResource(id = R.string.todo_title),
                    fontWeight = if (currentRoute == Tabs.TODO_ROUTE) FontWeight.Bold else FontWeight.Normal
                )
            },
            badge = {
                Text(
                    text = unfinishedTodoCount.toString(),
                    fontWeight = if (currentRoute == Tabs.TODO_ROUTE) FontWeight.Bold else FontWeight.Normal
                )
            },
            icon = { Icon(Icons.Rounded.CollectionsBookmark, null) },
            selected = currentRoute == Tabs.TODO_ROUTE,
            onClick = { navigateToTodo(); closeDrawer() },
            shape = RoundedCornerShape(15),
            colors = NavigationDrawerItemDefaults.colors(
                unselectedTextColor = LocalColorScheme.current.foregroundColor,
                unselectedIconColor = LocalColorScheme.current.foregroundColor,
                selectedTextColor = LocalColorScheme.current.activeForegroundColor,
                selectedContainerColor = LocalColorScheme.current.activeBackgroundColor,
                selectedIconColor = LocalColorScheme.current.activeForegroundColor,
            )
        )
        NavigationDrawerItem(
            modifier = Modifier.padding(
                start = NavigationDrawerItemDefaults.ItemPadding.calculateStartPadding(
                    LayoutDirection.Ltr
                ),
                top = NavigationDrawerItemDefaults.ItemPadding.calculateTopPadding(),
                end = NavigationDrawerItemDefaults.ItemPadding.calculateEndPadding(LayoutDirection.Rtl),
                bottom = NavigationDrawerItemDefaults.ItemPadding.calculateBottomPadding(),
            ),
            label = {
                Text(
                    stringResource(id = R.string.complete_title),
                    fontWeight = if (currentRoute == Tabs.COMPLETE_ROUTE) FontWeight.Bold else FontWeight.Normal
                )
            },
            icon = {
                Icon(
                    Icons.Rounded.CheckBox, null
                )
            },
            badge = {
                Text(
                    text = finishedTodoCount.toString(),
                    fontWeight = if (currentRoute == Tabs.TODO_ROUTE) FontWeight.Bold else FontWeight.Normal
                )
            },
            selected = currentRoute == Tabs.COMPLETE_ROUTE,
            onClick = { navigateToComplete(); closeDrawer() },
            shape = RoundedCornerShape(15),
            colors = NavigationDrawerItemDefaults.colors(
                unselectedTextColor = LocalColorScheme.current.foregroundColor,
                unselectedIconColor = LocalColorScheme.current.foregroundColor,
                selectedTextColor = LocalColorScheme.current.activeForegroundColor,
                selectedContainerColor = LocalColorScheme.current.activeBackgroundColor,
                selectedIconColor = LocalColorScheme.current.activeForegroundColor,
            )
        )
        NavigationDrawerItem(
            modifier = Modifier.padding(
                start = NavigationDrawerItemDefaults.ItemPadding.calculateStartPadding(
                    LayoutDirection.Ltr
                ),
                top = NavigationDrawerItemDefaults.ItemPadding.calculateTopPadding(),
                end = NavigationDrawerItemDefaults.ItemPadding.calculateEndPadding(LayoutDirection.Rtl),
                bottom = NavigationDrawerItemDefaults.ItemPadding.calculateBottomPadding(),
            ),
            label = {
                Text(
                    stringResource(id = R.string.trash_title),
                    fontWeight = if (currentRoute == Tabs.TRASH_ROUTE) FontWeight.Bold else FontWeight.Normal
                )
            },
            badge = {
                Text(
                    text = deleteTodoCount.toString(),
                    fontWeight = if (currentRoute == Tabs.TODO_ROUTE) FontWeight.Bold else FontWeight.Normal
                )
            },
            icon = { Icon(Icons.Rounded.Delete, null) },
            selected = currentRoute == Tabs.TRASH_ROUTE,
            onClick = { navigateToTrash(); closeDrawer() },
            shape = RoundedCornerShape(15),
            colors = NavigationDrawerItemDefaults.colors(
                unselectedTextColor = LocalColorScheme.current.foregroundColor,
                unselectedIconColor = LocalColorScheme.current.foregroundColor,
                selectedTextColor = LocalColorScheme.current.activeForegroundColor,
                selectedContainerColor = LocalColorScheme.current.activeBackgroundColor,
                selectedIconColor = LocalColorScheme.current.activeForegroundColor,
            )
        )
    }
}
