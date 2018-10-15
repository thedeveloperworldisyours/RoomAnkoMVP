package com.thedeveloperworldisyours.roomankomvp

import android.app.Application
import android.arch.persistence.room.Room
import com.thedeveloperworldisyours.roomankomvp.database.AppDatabase

/**
 * Created by javiergonzalezcabezas on 15/10/18.
 */
class TasksApp: Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(this, AppDatabase::class.java, "tasks-db").build()
    }
}