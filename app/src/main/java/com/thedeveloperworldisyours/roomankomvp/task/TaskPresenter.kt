package com.thedeveloperworldisyours.roomankomvp.task

import com.thedeveloperworldisyours.roomankomvp.TasksApp
import com.thedeveloperworldisyours.roomankomvp.database.Task
import com.thedeveloperworldisyours.roomankomvp.database.TaskDao
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by javiergonzalezcabezas on 9/10/18.
 */
class TaskPresenter constructor(val taskDao: TaskDao) {

    lateinit var tasks: MutableList<Task>

    var presentation: TaskPresentation? = null

    fun onCreate(taskPresentation: TaskPresentation) {
        presentation = taskPresentation
        loadTasks()
    }

    fun onDestroy() {
        presentation = null
    }

    fun loadTasks() {

        //presentation?.showTasks(tasks)

        doAsync {
            tasks = TasksApp.database.taskDao().getAllTasks()
            uiThread {
                presentation?.setUpRecyclerView(tasks)
            }
        }
    }

    fun updateTask(task: Task) {
        doAsync {
            task.completed = !task.completed
            TasksApp.database.taskDao().updateTask(task)
        }
    }

    fun deleteTask(task: Task){
        doAsync {
            val position = tasks.indexOf(task)
            TasksApp.database.taskDao().deleteTask(task)
            tasks.remove(task)
            uiThread {
                presentation?.notifyItemRemoved(position)
            }
        }
    }

    fun addTask(task: Task){
        doAsync {
            val idTask = TasksApp.database.taskDao().insertTask(task)
            val recoveryTask = TasksApp.database.taskDao().findTaskById(idTask)
            uiThread {
                tasks.add(recoveryTask)
                presentation?.add(tasks)
            }
        }
    }

}