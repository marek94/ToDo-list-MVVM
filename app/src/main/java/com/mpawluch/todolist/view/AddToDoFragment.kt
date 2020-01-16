package com.mpawluch.todolist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mpawluch.todolist.BR
import com.mpawluch.todolist.R
import com.mpawluch.todolist.databinding.FragmentAddTodoBinding
import com.mpawluch.todolist.utils.provideViewModel
import com.mpawluch.todolist.viewmodel.ToDoViewModel
import kotlinx.android.synthetic.main.fragment_add_todo.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddToDoFragment : BaseFragment() {

    private val viewModel by lazy { provideViewModel { ToDoViewModel(toDoRepository) } }

    override fun getLayout() = R.layout.fragment_add_todo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddTodoBinding.inflate(inflater, container, false)
        binding.setVariable(BR.vm, viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save_button.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                viewModel.save()
            }
            activity?.onBackPressed()
        }
    }
}