package com.mpawluch.todolist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mpawluch.todolist.BR
import com.mpawluch.todolist.database.entity.ToDo
import com.mpawluch.todolist.databinding.ListItemBinding
import com.mpawluch.todolist.viewmodel.ToDoElementViewModel

class ToDoAdapter(var items: List<ToDo> = listOf()) : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(listItemBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val toDo = items[position]
        val elementViewModel = ToDoElementViewModel(toDo.title)
        holder.bind(elementViewModel)
    }

    class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: ToDoElementViewModel) {
            binding.setVariable(BR.vm, viewModel)
        }
    }
}