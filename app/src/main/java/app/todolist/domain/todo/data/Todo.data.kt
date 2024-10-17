package app.todolist.domain.todo.data

import app.todolist.domain.todo.entity.Todo
import java.sql.Timestamp
import java.util.UUID

data class TodoInitialData(val list: List<Todo>) {
    companion object {
        val default = listOf(
            Todo(
                UUID.randomUUID(),
                "Implement user login feature",
                1728549289000L,
                Timestamp.valueOf("2024-10-10 10:00:00")
            ),
            Todo(
                UUID.randomUUID(),
                "Fix bug in payment processing",
                1728462889000L,
                Timestamp.valueOf("2024-10-09 14:30:00")
            ),
            Todo(
                UUID.randomUUID(),
                "Write unit tests for new API",
                1730363689000L,
                Timestamp.valueOf("2024-10-11 09:00:00")
            ),
            Todo(
                UUID.randomUUID(),
                "Code review for pull request #22",
                1729154089000L,
                Timestamp.valueOf("2024-10-12 11:15:00")
            ),
            Todo(
                UUID.randomUUID(),
                "Refactor database schema",
                null,
                Timestamp.valueOf("2024-10-13 16:45:00")
            ),
            Todo(
                UUID.randomUUID(),
                "Deploy application to staging",
                null,
                Timestamp.valueOf("2024-10-13 17:30:00")
            ),
            Todo(
                UUID.randomUUID(),
                "Optimize performance for large datasets",
                null,
                Timestamp.valueOf("2024-10-14 10:00:00")
            ),
            Todo(
                UUID.randomUUID(),
                "Update documentation for API v2",
                1728950400000L,
                Timestamp.valueOf("2024-10-14 09:30:00")
            ),
            Todo(
                UUID.randomUUID(),
                "Design new landing page UI",
                1729382400000L,
                Timestamp.valueOf("2024-10-14 11:00:00")
            ),
            Todo(
                UUID.randomUUID(),
                "Setup CI/CD pipeline",
                null,
                Timestamp.valueOf("2024-10-15 12:00:00")
            ),
            Todo(
                UUID.randomUUID(),
                "Research new authentication methods",
                null,
                Timestamp.valueOf("2024-10-15 14:00:00")
            )
        )
    }
}
