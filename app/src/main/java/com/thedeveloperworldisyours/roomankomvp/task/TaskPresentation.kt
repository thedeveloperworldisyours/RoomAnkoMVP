package com.thedeveloperworldisyours.roomankomvp.task

import android.content.Context
import com.thedeveloperworldisyours.roomankomvp.database.Task

/**
 * Created by javiergonzalezcabezas on 9/10/18.
 */
interface TaskPresentation {

    fun taskAddedAt(position: Int)

    fun scrollTo(position: Int)

    fun setUpRecyclerView(tasks: List<Task>)

    fun notifyItemRemoved(position: Int)

    fun add(tasks: MutableList<Task>)

    fun clearFocus()

    fun Context.hideKeyboard()

}