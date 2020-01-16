package com.mpawluch.todolist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mpawluch.todolist.database.dao.ToDoDao
import com.mpawluch.todolist.database.entity.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao

    companion object {
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        operator fun invoke(context: Context): ToDoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, ToDoDatabase::class.java, "todo_database.db").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}