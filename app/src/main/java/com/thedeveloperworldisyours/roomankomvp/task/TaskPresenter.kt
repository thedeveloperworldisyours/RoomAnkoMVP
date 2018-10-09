package com.thedeveloperworldisyours.roomankomvp.task

import com.thedeveloperworldisyours.roomankomvp.database.Task
import com.thedeveloperworldisyours.roomankomvp.database.TaskDao
import java.util.*

/**
 * Created by javiergonzalezcabezas on 9/10/18.
 */
class TaskPresenter constructor(val taskDao: TaskDao) {

    val compositeDisposable = CompositeDisposable()
    var tasks = ArrayList<Task>()

    var presentation: TaskPresentation? = null

    fun onCreate(toDoPresentation: TaskPresentation) {
        presentation = toDoPresentation
        loadTasks()
    }

    fun onDestroy() {
        compositeDisposable.dispose()
        presentation = null
    }

    fun loadTasks() {

        presentation?.showTasks(tasks)
    }

    fun addNewTask(taskDescription: String) {

    }
}