package com.mpawluch.todolist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mpawluch.todolist.database.entity.ToDo
import com.mpawluch.todolist.database.repository.IToDoRepository

class ToDoViewModel(private val repository: IToDoRepository) : ViewModel() {
    val toDo = MutableLiveData<String>()

    suspend fun save() {
        val element = ToDo(title = toDo.value ?: "")
        repository.insert(element)
    }
}