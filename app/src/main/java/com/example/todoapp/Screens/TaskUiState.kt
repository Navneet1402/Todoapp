package com.example.todoapp.Screens

import com.example.todoapp.data.Task

data class TaskUiState (
    val tasks: List<Task> = emptyList(),
    val error: String = "",
    val status: String = "",
)