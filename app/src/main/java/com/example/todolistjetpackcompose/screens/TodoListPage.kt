package com.example.todolistjetpackcompose.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.todolistjetpackcompose.models.getFakeTodo
import com.example.todolistjetpackcompose.viewmodel.TodoViewModel
import com.example.todolistjetpackcompose.widgets.LayoutTodoItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListPage(viewModel: TodoViewModel) {

    val todoList by viewModel.todoList.observeAsState()


    var inputText by remember {
        mutableStateOf("")
    }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .heightIn(max = 100.dp) // Set maximum height
                    .padding(end = 8.dp)
                    .verticalScroll(scrollState) // Enable vertical scrolling
            ) {

                OutlinedTextField(
                    value = inputText,
                    onValueChange = {
                        inputText = it
                    },
                    placeholder = {
                        Text(text = "Enter todo text here ")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),// // Adds space between TextField and Button

                )


            }
            Button(
                onClick = {
                    viewModel.addTodo(inputText)
                    inputText = ""

                },
                modifier = Modifier
                    .wrapContentWidth() // Ensures the button takes only the space needed
            ) {
                Text(text = "Add")
            }

        }

        todoList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it) { index, item ->
                        LayoutTodoItem(item, onDelete = {
                            viewModel.deleteTodo(item.id)
                        })
                    }
                }
            )
        } ?: Text(
            text = "No Items yet ",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )


    }
}
