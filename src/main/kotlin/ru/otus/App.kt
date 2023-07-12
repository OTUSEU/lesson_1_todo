package ru.otus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// сборная аннотация которой одной можно сканировать весь класс
@SpringBootApplication
open class TaskApp

fun main() {
    runApplication<TaskApp>()
}
