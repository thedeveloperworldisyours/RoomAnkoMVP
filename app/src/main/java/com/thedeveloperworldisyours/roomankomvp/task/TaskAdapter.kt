package com.thedeveloperworldisyours.roomankomvp.task
import com.thedeveloperworldisyours.roomankomvp.R
import com.thedeveloperworldisyours.roomankomvp.database.Task
import kotlinx.android.synthetic.main.task_item.view.*

/**
 * Created by javiergonzalezcabezas on 14/10/18.
 */
class TaskAdapter(var tasks: List<Task>) : android.support.v7.widget.RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: android.view.ViewGroup, type: Int): TaskViewHolder {
        return TaskViewHolder(parent)
    }

    override fun onBindViewHolder(viewHolder: TaskViewHolder, position: Int) {
        viewHolder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    inner class TaskViewHolder(parent: android.view.ViewGroup) : android.support.v7.widget.RecyclerView.ViewHolder(android.view.LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)) {

        fun bind(task: Task) = with(itemView) {
            task_item_done_checkBox.text = task.description
            task_item_done_checkBox.isChecked = task.completed
        }
    }
}