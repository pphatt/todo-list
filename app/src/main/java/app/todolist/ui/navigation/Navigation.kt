package app.todolist.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

/**
 * Destinations used in the [AppNavigation].
 */
object Tabs {
    const val TODO_ROUTE = "Todo"
    const val TRASH_ROUTE = "Trash"
    const val DETAILS_ROUTE = "Details"
    const val COMPLETE_ROUTE = "Completed"
}

/**
 * Models the navigation actions in the app.
 */
class NavigationActions(navHostController: NavHostController) {
    val navigateToTodo: () -> Unit = {
        navHostController.navigate(Tabs.TODO_ROUTE) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToEditTodo: (todoId: String) -> Unit = {
        navHostController.navigate("${Tabs.TODO_ROUTE}/${it}") {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
        }
    }
    val navigateToDetails: () -> Unit = {
        navHostController.navigate(Tabs.DETAILS_ROUTE) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
        }
    }
    val navigateToEditDetails: (todoId: String?) -> Unit = {
        navHostController.navigate("${Tabs.DETAILS_ROUTE}/${it}") {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
        }
    }
    val navigateToTrash: () -> Unit = {
        navHostController.navigate(Tabs.TRASH_ROUTE) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToEditTrash: (todoId: String) -> Unit = {
        navHostController.navigate("${Tabs.TRASH_ROUTE}/${it}") {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
        }
    }
    val navigateToComplete: () -> Unit = {
        navHostController.navigate(Tabs.COMPLETE_ROUTE) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToEditComplete: (todoId: String) -> Unit = {
        navHostController.navigate("${Tabs.COMPLETE_ROUTE}/${it}") {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
        }
    }
}
