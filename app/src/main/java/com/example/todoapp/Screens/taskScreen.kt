package com.example.todoapp.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.data.Task
import com.example.todoapp.ui.theme.TodoappTheme

@Composable
fun TaskScreen(
    uiState:TaskUiState = TaskUiState(),
    onEvent: (TaskEvent) -> Unit ={},
) {
    Scaffold(
        bottomBar = {
            TaskBottomBar(onEvent=onEvent)
        }

    ) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(uiState.tasks){
                        task ->
                    TaskItem(task = task , onEvent= onEvent)
                }

            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskItem(task: Task, onEvent: (TaskEvent) -> Unit) {
    Card(onClick = {},
        modifier = Modifier.fillMaxWidth()) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                text = task.name, modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Checkbox(checked = task.isCompleted, onCheckedChange = {})
        }
        if (task.isImportant){
            Badge(){
                Text(text = "Important", modifier = Modifier.padding(8.dp))
            }
        }

    }
}

@Composable
fun TaskBottomBar(onEvent: (TaskEvent) -> Unit) {
    FloatingActionButton(onClick = {onEvent(TaskEvent.addtask)}) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "add Task"
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun TaskScreenPreview() {
    TodoappTheme {
        TaskScreen(
            uiState = TaskUiState(
                tasks = listOf(
                    Task("Do Laundry"),
                    Task("Clean Room"),
                    Task("Buy Groceries👌🍐🍏🍋"),
                    Task("Sleep😴")
                )
            )
        )
    }

}