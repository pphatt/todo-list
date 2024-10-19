package app.todolist.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.todolist.domain.todo.entity.Todo
import app.todolist.presentation.screen.complete.CompletedRoute
import app.todolist.presentation.screen.details.DetailsRoute
import app.todolist.presentation.screen.edit.EditRoute
import app.todolist.presentation.screen.todo.TodoRoute
import app.todolist.presentation.screen.share.ShareScreen
import app.todolist.presentation.screen.trash.TrashRoute
import kotlinx.coroutines.Job

const val TODO_ID = "todoId"

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    navigationActions: NavigationActions,
    startDestination: String = Tabs.TODO_ROUTE,

    drawerState: DrawerState,
    currentRoute: String,

    temporalTodoList: SnapshotStateList<Todo>,

    openDrawer: () -> Job,
    closeDrawer: () -> Job
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(
            route = Tabs.TODO_ROUTE,
        ) {
            ShareScreen(
                navigationActions = navigationActions,
                drawerState = drawerState,
                currentRoute = currentRoute,
                closeDrawer = closeDrawer,
                content = {
                    TodoRoute(
                        navigateToDetails = navigationActions.navigateToDetails,
                        openDrawer = openDrawer,
                        temporalTodoList = temporalTodoList,
                        onTodoClick = { todo ->
                            val todoId = todo.id.toString()
                            navigationActions.navigateToEditTodo(todoId)
                        }
                    )
                }
            )
        }
        composable(
            route = "${Tabs.TODO_ROUTE}/{${TODO_ID}}",
            arguments = listOf(
                navArgument(TODO_ID) {
                    type = NavType.StringType
                }
            ),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up,
                    tween(300),
                    initialOffset = { fullHeight -> fullHeight / 3 }
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Down,
                    tween(300),
                    targetOffset = { fullHeight -> fullHeight / 3 }
                ) + fadeOut(animationSpec = tween(durationMillis = 200))
            }
        ) { backStackEntry ->
            val todoId = backStackEntry.arguments?.getString(TODO_ID)

            EditRoute(
                todoId = todoId,
                navigateToTodo = { navigationActions.navigateToTodo() },
                navigateToTrash = { navigationActions.navigateToTrash() },
                navigateToComplete = { navigationActions.navigateToComplete() },
                navigateToEditDetails = { navigationActions.navigateToEditDetails(todoId) }
            )
        }
        composable(
            route = Tabs.DETAILS_ROUTE,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up,
                    tween(300),
                    initialOffset = { fullHeight -> fullHeight / 3 }
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Down,
                    tween(300),
                    targetOffset = { fullHeight -> fullHeight / 3 }
                ) + fadeOut(animationSpec = tween(durationMillis = 200))
            }
        ) {
            DetailsRoute(
                navigateToTodo = { navigationActions.navigateToTodo() },
                newTemporalTodoList = temporalTodoList
            )
        }
        composable(
            route = "${Tabs.DETAILS_ROUTE}/{${TODO_ID}}",
            arguments = listOf(
                navArgument(TODO_ID) {
                    type = NavType.StringType
                }
            ),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up,
                    tween(300),
                    initialOffset = { fullHeight -> fullHeight / 3 }
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Down,
                    tween(300),
                    targetOffset = { fullHeight -> fullHeight / 3 }
                ) + fadeOut(animationSpec = tween(durationMillis = 200))
            }
        ) { backStackEntry ->
            val todoId = backStackEntry.arguments?.getString(TODO_ID)

            DetailsRoute(
                todoId = todoId,
                navigateToTodo = { navigationActions.navigateToTodo() },
                newTemporalTodoList = temporalTodoList
            )
        }
        composable(
            route = Tabs.TRASH_ROUTE,
        ) {
            ShareScreen(
                navigationActions = navigationActions,
                drawerState = drawerState,
                currentRoute = currentRoute,
                closeDrawer = closeDrawer,
                content = {
                    TrashRoute(
                        openDrawer = openDrawer,
                        onEditTodoClick = { todoId ->
                            navigationActions.navigateToEditTrash(todoId)
                        }
                    )
                }
            )
        }
        composable(
            route = "${Tabs.TRASH_ROUTE}/{${TODO_ID}}",
            arguments = listOf(
                navArgument("todoId") {
                    type = NavType.StringType
                }
            ),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up,
                    tween(300),
                    initialOffset = { fullHeight -> fullHeight / 3 }
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Down,
                    tween(300),
                    targetOffset = { fullHeight -> fullHeight / 3 }
                ) + fadeOut(animationSpec = tween(durationMillis = 200))
            }
        ) { backStackEntry ->
            val todoId = backStackEntry.arguments?.getString(TODO_ID)

            EditRoute(
                todoId = todoId,
                isCurrentTrashRoute = true,
                navigateToTodo = { navigationActions.navigateToTodo() },
                navigateToTrash = { navigationActions.navigateToTrash() },
                navigateToComplete = { navigationActions.navigateToComplete() },
                navigateToEditDetails = { navigationActions.navigateToEditDetails(todoId) }
            )
        }
        composable(
            route = Tabs.COMPLETE_ROUTE,
        ) {
            ShareScreen(
                navigationActions = navigationActions,
                drawerState = drawerState,
                currentRoute = currentRoute,
                closeDrawer = closeDrawer,
                content = {
                    CompletedRoute(
                        openDrawer = openDrawer,
                        onEditTodoClick = { todoId ->
                            navigationActions.navigateToEditComplete(todoId)
                        }
                    )
                }
            )
        }
        composable(
            route = "${Tabs.COMPLETE_ROUTE}/{${TODO_ID}}",
            arguments = listOf(
                navArgument("todoId") {
                    type = NavType.StringType
                }
            ),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up,
                    tween(300),
                    initialOffset = { fullHeight -> fullHeight / 3 }
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Down,
                    tween(300),
                    targetOffset = { fullHeight -> fullHeight / 3 }
                ) + fadeOut(animationSpec = tween(durationMillis = 200))
            }
        ) { backStackEntry ->
            val todoId = backStackEntry.arguments?.getString(TODO_ID)

            EditRoute(
                todoId = todoId,
                isCurrentCompleteRoute = true,
                navigateToTodo = { navigationActions.navigateToTodo() },
                navigateToTrash = { navigationActions.navigateToTrash() },
                navigateToComplete = { navigationActions.navigateToComplete() },
                navigateToEditDetails = { navigationActions.navigateToEditDetails(todoId) }
            )
        }
    }
}
