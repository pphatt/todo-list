package app.todolist.presentation.screen.edit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.todolist.ui.theme.LocalColorScheme

@Composable
fun TodoTextPlaceholder(
    content: String,
    isCurrentTrashRoute: Boolean = false,
    isCurrentCompleteRoute: Boolean = false,
    onNavigateToEditTodo: () -> Unit,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .heightIn(min = 200.dp)
            .wrapContentHeight(align = Alignment.CenterVertically, unbounded = true)
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
            .background(LocalColorScheme.current.cardBackgroundColor)
            .clickable(
                interactionSource = null,
                indication = null,
                onClick = { if (!isCurrentTrashRoute && !isCurrentCompleteRoute) onNavigateToEditTodo() }
            ),
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        IconButton(
            onClick = onNavigateBack
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                tint = MaterialTheme.colorScheme.outline,
                contentDescription = "",
            )
        }

        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                cursorColor = LocalColorScheme.current.cursorColor
            ),
            modifier = Modifier
                .wrapContentHeight()
                .clickable(
                    interactionSource = null,
                    indication = null,
                    onClick = { if (!isCurrentTrashRoute && !isCurrentCompleteRoute) onNavigateToEditTodo() }
                ),
            textStyle = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W700),
            placeholder = {
                Text(
                    text = "Todo goes here",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = LocalColorScheme.current.primaryCardForegroundColor,
                        fontWeight = FontWeight.W500
                    )
                )
            },
            value = content,
            onValueChange = {},
            readOnly = true
        )

        Spacer(modifier = Modifier.height(40.dp))
    }
}
