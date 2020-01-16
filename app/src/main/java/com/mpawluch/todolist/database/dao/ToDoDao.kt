package com.mpawluch.todolist.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mpawluch.todolist.database.entity.ToDo

@Dao
interface ToDoDao {
    @Insert
    suspend fun insert(toDo: ToDo)

    @Delete
    suspend fun delete(vararg toDos: ToDo)

    @Query("SELECT * FROM ToDo")
    fun getAll(): LiveData<List<ToDo>>
}