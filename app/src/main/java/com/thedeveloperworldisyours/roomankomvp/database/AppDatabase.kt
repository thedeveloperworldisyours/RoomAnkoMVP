package com.thedeveloperworldisyours.roomankomvp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by javiergonzalezcabezas on 8/10/18.
 */
@Database(entities = arrayOf(Task::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}