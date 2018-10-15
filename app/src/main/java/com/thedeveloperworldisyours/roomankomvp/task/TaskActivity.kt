package com.thedeveloperworldisyours.roomankomvp.task

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.thedeveloperworldisyours.roomankomvp.R
import com.thedeveloperworldisyours.roomankomvp.database.Task
import kotlinx.android.synthetic.main.task_activity.*

/**
 * Created by javiergonzalezcabezas on 14/10/18.
 */
class TaskActivity : AppCompatActivity(), TaskPresentation {

    lateinit var presenter: TaskPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_activity)
        task_recyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        task_recyclerView?.adapter = TaskAdapter(emptyList())

        task_button?.setOnClickListener({ presenter.addNewTask(task_editText.text.toString()) })

        presenter.onCreate(this)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showTasks(tasks: List<Task>) {
        task_recyclerView.adapter = TaskAdapter(tasks)
    }

    override fun taskAddedAt(position: Int) {
        task_recyclerView.adapter?.notifyItemInserted(position)
    }

    override fun scrollTo(position: Int) {
        task_recyclerView.smoothScrollToPosition(position)
    }
}