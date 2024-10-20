package app.todolist.presentation.screen.share.viewmodel

data class UIState(
    val unfinishedTodoCount: Int,
    val finishedTodoCount: Int,
    val deleteTodoCount: Int,
) {
    companion object {
        val default = UIState(
            unfinishedTodoCount = 0,
            finishedTodoCount = 0,
            deleteTodoCount = 0
        )
    }
}
