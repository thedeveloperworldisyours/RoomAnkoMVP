package com.thedeveloperworldisyours.roomankomvp.database

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

/**
 * Created by javiergonzalezcabezas on 8/10/18.
 */
@Dao
interface TaskDao {

    @Query("select * from task")
    fun getAllTasks(): MutableList<Task>

    @Query("select * from task where id = :id")
    fun findTaskById(id: Long): Task

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task):Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)


}