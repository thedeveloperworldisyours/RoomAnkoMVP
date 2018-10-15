package com.thedeveloperworldisyours.roomankomvp.task

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.inputmethod.InputMethodManager
import com.thedeveloperworldisyours.roomankomvp.R
import com.thedeveloperworldisyours.roomankomvp.database.Task
import kotlinx.android.synthetic.main.task_activity.*

/**
 * Created by javiergonzalezcabezas on 14/10/18.
 */
class TaskActivity : AppCompatActivity(), TaskPresentation {

    lateinit var presenter: TaskPresenter
    lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_activity)

        task_button?.setOnClickListener({ presenter.addTask(Task(description = task_editText.text.toString()))})

        presenter.onCreate(this)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun taskAddedAt(position: Int) {
        task_recyclerView.adapter?.notifyItemInserted(position)
    }

    override fun scrollTo(position: Int) {
        task_recyclerView.smoothScrollToPosition(position)
    }

    override fun setUpRecyclerView(tasks: List<Task>) {
        adapter = TaskAdapter(tasks, { presenter.updateTask(it) }, {presenter.deleteTask(it)})
        task_recyclerView.setHasFixedSize(true)
        task_recyclerView.layoutManager = LinearLayoutManager(this)
        task_recyclerView.adapter = adapter
    }

    override fun notifyItemRemoved(position: Int) {
        adapter.notifyItemRemoved(position)
    }

    override fun clearFocus(){
        task_editText.setText("")
    }

    override fun Context.hideKeyboard() {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    }

    override fun add(tasks: MutableList<Task>) {
        adapter.notifyItemInserted(tasks.size)
        clearFocus()
        hideKeyboard()
    }
}
