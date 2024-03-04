package com.example.todoapp.data

data class Task(
    val name: String = "Task",
    val isImportant: Boolean = false,
    val isCompleted: Boolean = false
)

class TaskRepository{
    private val tasks = mutableListOf<Task>(
        Task("Do Laundary"),
        Task("Clean Room"),
        Task("Buy Groceries")
    )

    fun addTask(task: Task){
        tasks.add(task)
    }
    fun getTasks() = tasks
}