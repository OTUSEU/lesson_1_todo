package menu

/**
 * нет пакета!!
 * класс с именами fun из menu.Actions
 * taskActions = mapOf( ставит в соответствие
 * эти имена <--> имена функций из класса menu.Actions
 * Перемудрено и недоделано
 * вызывается только из main чтобы позвать нужную функцию (по номеру меню)
 * taskActions[menu.Actions.values()[action - 1]].call(repository)
 *
 */
enum class Actions {
    ADD_TASK,
    DELETE_TASK,
    LIST_TASKS,
    LIST_NON_COMPLETED_TASKS,
    COMPLETE_TASK,
    UNCOMPLETE_TASK,
    QUIT
}

