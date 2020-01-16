package com.mpawluch.todolist.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mpawluch.todolist.R
import com.mpawluch.todolist.utils.provideViewModel
import com.mpawluch.todolist.view.adapter.ToDoAdapter
import com.mpawluch.todolist.viewmodel.ToDoFragmentViewModel
import kotlinx.android.synthetic.main.fragment_todo_list.*

class ToDoListFragment : BaseFragment() {

    private val adapter by lazy { ToDoAdapter() }

    private val viewModel by lazy { provideViewModel { ToDoFragmentViewModel(toDoRepository) } }

    override fun getLayout() = R.layout.fragment_todo_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

        add_new_element.setOnClickListener {
            val action = ToDoListFragmentDirections.actionListFragmentToToDoFragment()
            findNavController().navigate(action)
        }
    }

    private fun initializeView() {
        viewModel.getToDoList().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
    }
}