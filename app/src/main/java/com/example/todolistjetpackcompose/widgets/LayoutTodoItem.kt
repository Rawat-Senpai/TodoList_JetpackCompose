package com.example.todolistjetpackcompose.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistjetpackcompose.models.TodoDataClass
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun LayoutTodoItem(item: TodoDataClass,onDelete :()->Unit) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(.9f)
        ) {
            Text(
                text = item.title,
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.01.sp
            )
            Spacer(Modifier.height(5.dp))
            Text(
                text = SimpleDateFormat(
                    "HH:mm:aa, dd/mm",
                    Locale.ENGLISH
                ).format(item.createdAt),
                fontSize = 12.sp
            )
        }

        IconButton(onClick = onDelete ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete",
                tint = Color.White,
                modifier = Modifier.weight(.1f)
            )
        }



    }
}