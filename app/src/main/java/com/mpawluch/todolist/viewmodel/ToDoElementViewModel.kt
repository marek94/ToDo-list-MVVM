package com.mpawluch.todolist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoElementViewModel(title: String): ViewModel() {
    private val _title = MutableLiveData(title)

    val title: LiveData<String> = _title

    val checked = MutableLiveData(false)
}