package ru.otus.service

import data.Task
import data.TasksRepository
import org.springframework.stereotype.Service
import ru.otus.http.error.AddCompleteTaskExeption

@Service
class TaskService(private val taskRepo: TasksRepository) {

    fun addTask(task:Task) : Task {
        if (task.completed) {
            throw AddCompleteTaskExeption()
        }
        val id = taskRepo.addTask(task)
        task.id = id
        return task
    }

    fun deleteTask(id: Int){
        if (id<0) {
            throw InvalidTaskExeptiob()
        }
    }
}