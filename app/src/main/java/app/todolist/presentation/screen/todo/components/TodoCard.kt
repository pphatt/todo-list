package app.todolist.presentation.screen.todo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.todolist.domain.todo.entity.Todo
import app.todolist.ui.theme.LocalColorScheme
import app.todolist.utils.convertMillisToDate

@Composable
fun TodoCard(
    todo: Todo,
    isNew: Boolean,
    onTodoClick: (Todo) -> Unit
) {
    Card(
        modifier = Modifier
            .clickable {
                onTodoClick(todo)
            },
        colors = CardDefaults.cardColors(
            containerColor = LocalColorScheme.current.cardBackgroundColor
        ),
        shape = RoundedCornerShape(15.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(start = 30.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                ) {
                    if (isNew) {
                        Text(
                            text = "N",
                            color = LocalColorScheme.current.lightSecondaryCardForegroundColor,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    Text(
                        text = todo.content,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W600
                    )
                }

                if (todo.dueDate != null) {
                    Text(
                        text = convertMillisToDate(todo.dueDate),
                        color = LocalColorScheme.current.secondaryCardForegroundColor,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.W500
                    )
                }
            }
        }
    }
}