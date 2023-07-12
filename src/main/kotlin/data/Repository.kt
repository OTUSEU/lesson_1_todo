package data

import org.springframework.stereotype.Component

/**
 * abstract class TasksRepository здесь реализуется
 * Котлин рекомендует через interface
 */
@Component
class TasksRepositoryMemory : TasksRepository() {
    // сама типа "БАЗА" задач, как-бы - имитация в mutableList
    val tasks = mutableListOf<Task>()
    /**
     * Возвращает первый элемент, дающий наибольшее значение данной функции или null если элементов нет.
     * Используется только в ADD для следующего номера задачи
     * можно применять в Test
     */
    fun nextId(): Int = tasks.maxByOrNull { it.id ?: 0 }?.id?.inc() ?: 1
    /**
     * Получить полный список задач (completed = false)
     * completed = true - законченная задача
     * Если false - то возвращается список true задач - активные
     * иначе полный список задач
     */
    override fun getTasks(completed: Boolean): List<Task> {
        return tasks.filter { it.completed == completed }
//        var filteredTasks = tasks.toList()
//        if (!completed) filteredTasks = filteredTasks.filter { !it.completed }
//        return filteredTasks
    }
    /**
     * Добавить задачу с очередным номером = последний + 1
     */
    override fun addTask(task: Task): Int {
        val id = nextId()
        tasks.add(task.copy(id = id))
        return id
    }
    /**
     * Удалить ВСЕ задачи с этим номером
     */
    override fun deleteTask(id: Int) {
        tasks.removeAll { it.id == id }
    }
    /**
     * Закончить задачу - присвоить ее completed = true
     *
     */
    override fun completeTask(id: Int) {
        tasks.first { it.id == id }.completed = true
    }
    /**
     * Сделать задачу активной - присвоить ее completed = false
     */
    override fun uncompleteTask(id: Int) {
        tasks.first { it.id == id }.completed = false
    }
}
