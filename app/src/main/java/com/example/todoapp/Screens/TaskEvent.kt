package com.example.todoapp.Screens

sealed class TaskEvent {
    object addtask: TaskEvent()
    data class UpdateTask(val isComplete: Boolean) : TaskEvent()

}
