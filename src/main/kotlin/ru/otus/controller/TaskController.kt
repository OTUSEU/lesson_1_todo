package ru.otus.controller

import ru.otus.data.Task
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.otus.service.TaskService

@RestController             // сборная аннотация
@RequestMapping("api/v1/task")      // кусок пути где брать конкретные aoi
class TaskController(private  val taskService: TaskService) {

    @PostMapping
    fun addTask(@RequestBody task: Task): Task {
        // можно обернуть ответ, а обертку ResponseEntity или свой аналог см ниже
        return taskService.addTask(task)
    }
    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable("id") id: Int) {
        taskService.deleteTask(id)
    }
// переписано ниже в одну функцию changeTaskStatus
//    @PutMapping("/{id}/compete")
//    fun completeTask(@PathVariable id: Int): Task {
//    }
//    @PutMapping("/{id}/uncompete")
//    fun uncompleteTask(@PathVariable id: Int): Task {
//    }
    @PutMapping("/{id}")
    fun changeTaskStatus(@PathVariable id: Int, @RequestParam status:Boolean): Task {
    return if (status)
             taskService.completeTask(id)
     else   taskService.uncompleteTask(id)
}

    @GetMapping
    fun getTask(@RequestParam("status") status:Boolean ): List<Task> {
        return taskService.getTasks(status)
    }


}
// своя обертка типа Result
data class ApiResponse<T> (
    val body: T?,
    val error: String,
    val status: Boolean
)
