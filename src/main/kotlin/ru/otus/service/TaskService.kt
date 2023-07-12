package ru.otus.service

import data.Task
import data.TasksRepository
import org.springframework.stereotype.Service
import ru.otus.http.error.*

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
        if (id < 0) {
            throw InvalidTaskExeption()
        }
        taskRepo.getTasks(true).find { it.id == id }?.let {
            throw DeleteCompletetsdTaskExeption()
        }
        taskRepo.getTasks(false).find { it.id == id }?.let {
            taskRepo.completeTask(id)
        }?: TaskNotFoundExeption()
    }

    fun completeTask(id: Int): Task{
        if (id < 0) {
            throw InvalidTaskExeption()
        }
        taskRepo.getTasks(true).find { it.id == id }?.let {
            throw TaskCompletingError()
        }
        taskRepo.getTasks(false).find { it.id == id }?.let {
            taskRepo.completeTask(id)
        }?: TaskNotFoundExeption()
        return taskRepo.getTasks(true).find { it.id == id }!!
    }

    fun uncompleteTask(id: Int): Task {
        if (id < 0) {
            throw InvalidTaskExeption()
        }
        taskRepo.getTasks(true).find { it.id == id }?.let {
            throw TaskCompletingError()
        }
        taskRepo.getTasks(false).find { it.id == id }?.let {
            taskRepo.completeTask(id)
        }?: TaskNotFoundExeption()
        return taskRepo.getTasks(false).find { it.id == id }!!
    }

    fun getTasks(completed: Boolean): List<Task> {
        return taskRepo.getTasks(completed).sortedByDescending { it.priority }
    }

}