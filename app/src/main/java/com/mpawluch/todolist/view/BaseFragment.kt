package com.mpawluch.todolist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mpawluch.todolist.database.ToDoDatabase
import com.mpawluch.todolist.database.repository.IToDoRepository
import com.mpawluch.todolist.database.repository.ToDoRepository

abstract class BaseFragment : Fragment() {

    lateinit var database: ToDoDatabase

    protected val toDoRepository: IToDoRepository by lazy { ToDoRepository(database.todoDao()) }

    abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = ToDoDatabase.invoke(requireActivity())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }
}