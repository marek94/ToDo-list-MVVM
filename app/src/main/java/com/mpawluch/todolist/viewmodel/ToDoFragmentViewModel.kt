package com.mpawluch.todolist.viewmodel

import androidx.lifecycle.ViewModel
import com.mpawluch.todolist.database.repository.IToDoRepository

class ToDoFragmentViewModel(private val toDoRepository: IToDoRepository) : ViewModel() {
    private val toDoList = toDoRepository.getAll()

    fun getToDoList() = toDoList
}