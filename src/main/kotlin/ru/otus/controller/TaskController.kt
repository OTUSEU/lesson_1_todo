package ru.otus.controller

import data.Task
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/task")
class TaskController {

    @PostMapping
    fun addTask(@RequestBody task: Task): Task {
        // можно обернуть ответ, а обертку ResponseEntity или свой аналог см ниже

    }
    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable("id") id: Int) {

    }
//    @PutMapping("/{id}/compete")
//    fun completeTask(@PathVariable id: Int): Task {
//    }
//    @PutMapping("/{id}/uncompete")
//    fun uncompleteTask(@PathVariable id: Int): Task {
//    }
    @PutMapping("/{id}")
    fun changeTaskStatus(@PathVariable id: Int, @RequestParam status:Boolean): Task {

    }

    @GetMapping
    fun getTask(@RequestParam("status") status:Boolean ): List<Task> {

    }


}
// своя обертка
data class ApiResponse<T> (
    val body: T?,
    val error: String,
    val status:
)
