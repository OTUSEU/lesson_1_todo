package ru.otus.http.error

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExeptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Adding f complete task")
    @ExceptionHandler(AddCompleteTaskExeption::class)
    fun handleExeption(e: AddCompleteTaskExeption) {  }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Wromg task ID!")
    @ExceptionHandler(InvalidTaskExeption::class)
    fun handleExeption(e: InvalidTaskExeption) {  }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Delete completed task not allowed!")
    @ExceptionHandler(DeleteCompletetsdTaskExeption::class)
    fun handleExeption(e: DeleteCompletetsdTaskExeption) {  }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Task not found")
    @ExceptionHandler(TaskNotFoundExeption::class)
    fun handleExeption(e: TaskNotFoundExeption) {  }
    @ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = "Task already completed|uncompleted")
    @ExceptionHandler(TaskCompletingError::class)
    fun handleExeption(e: TaskCompletingError) {  }


}

class AddCompleteTaskExeption : Exception()
class InvalidTaskExeption : Exception()
class DeleteCompletetsdTaskExeption() : Exception()
class TaskNotFoundExeption() : Exception()
class TaskCompletingError() : Exception()
