package ru.otus.http.error

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExeptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Adding f complete task")
    @ExceptionHandler(AddCompleteTaskExeption::class)
    fun handleExeption() {

    }

}

class AddCompleteTaskExeption : Exception()
class InvalidTaskExeptiob : Exception()
