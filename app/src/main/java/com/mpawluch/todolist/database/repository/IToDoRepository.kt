package com.mpawluch.todolist.database.repository

import androidx.lifecycle.LiveData
import com.mpawluch.todolist.database.entity.ToDo

interface IToDoRepository {
    fun getAll(): LiveData<List<ToDo>>
    suspend fun insert(element: ToDo)
    suspend fun delete(vararg elements: ToDo)
}
