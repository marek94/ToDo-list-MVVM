package com.mpawluch.todolist.database.repository

import androidx.lifecycle.LiveData
import com.mpawluch.todolist.database.dao.ToDoDao
import com.mpawluch.todolist.database.entity.ToDo

class ToDoRepository(private val toDoDao: ToDoDao) : IToDoRepository {
    override fun getAll(): LiveData<List<ToDo>> = toDoDao.getAll()

    override suspend fun insert(element: ToDo) = toDoDao.insert(element)

    override suspend fun delete(vararg elements: ToDo) = toDoDao.delete(*elements)
}