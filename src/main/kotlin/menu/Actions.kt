package menu
/**
 * Модуль реагирования и на меню - исполнение функций меню
 * функции вызываются прямо из main (хитрым способом через enum и map)
 * taskActions[menu.Actions.values()[action - 1]]?.call(repository)
 */
import ru.otus.data.Priority
import ru.otus.data.Task
import ru.otus.data.TasksRepository
import kotlin.system.exitProcess
/**
 * 1- "Add task" --> menu.Actions.ADD_TASK to ::addTaskFromMenu
 */
fun addTaskFromMenu(repository: TasksRepository) {
    print("Adding task. Please enter task name: ")
    val name = readln()
    print("Choose task priority: (1-low, 2-medium, 3-high): ")
    var pr = readln().toIntOrNull() ?: 2
    pr = pr.coerceIn(1..3)
    val priority = Priority.values()[pr - 1]
    repository.addTask(Task(name = name, priority = priority))
}
/**
 * 3- "List all tasks" --> menu.Actions.LIST_TASKS to ::listTasksFromMenu
 */
fun listTasksFromMenu(repository: TasksRepository) {
    repository.getTasks().forEach(::println)
}
/**
 * 4- "List non-completed tasks" --> menu.Actions.LIST_NON_COMPLETED_TASKS to ::listNonCompletedTasksFromMenu
 */
fun listNonCompletedTasksFromMenu(repository: TasksRepository) {
    repository.getTasks(completed = false).forEach(::println)
}
/**
 * 2- "Delete task" --> menu.Actions.DELETE_TASK to ::deleteTasksFromMenu
 */
fun deleteTasksFromMenu(repository: TasksRepository) {
    print("Remove task. Please enter task id: ")
    val id = readln().toIntOrNull() ?: 0
    repository.deleteTask(id)
}
/**
 * 5- "Complete task" --> menu.Actions.COMPLETE_TASK to ::complete
 */

fun complete(repository: TasksRepository) {
    print("Complete task. Please enter task id: ")
    val id = readln().toIntOrNull() ?: 0
    repository.completeTask(id)
}
/**
 * 6- "Uncomplete task" --> menu.Actions.UNCOMPLETE_TASK to ::uncomplete
 */
fun uncomplete(repository: TasksRepository) {
    print("Uncomplete task. Please enter task id: ")
    val id = readln().toIntOrNull() ?: 0
    repository.uncompleteTask(id)
}
/** (не работает - работает добавил репозиторий)
 * 7- "Quit" --> menu.Actions.QUIT to ::quit
 */

fun quit(repository: TasksRepository) {
    exitProcess(0)
}

val taskActions = mapOf(
    Actions.ADD_TASK to ::addTaskFromMenu,
    Actions.LIST_TASKS to ::listTasksFromMenu,
    Actions.LIST_NON_COMPLETED_TASKS to ::listNonCompletedTasksFromMenu,
    Actions.DELETE_TASK to ::deleteTasksFromMenu,
    Actions.COMPLETE_TASK to ::complete,
    Actions.UNCOMPLETE_TASK to ::uncomplete,
    Actions.QUIT to ::quit,
)

