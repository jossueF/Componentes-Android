package com.example.recyclerview.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.adapters.RecyclerAdapter
import com.example.recyclerview.adapters.TodoUtil
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoList: MutableList<TodoUtil>
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        events()
        createAdapter()
    }

    private fun createList() : MutableList<TodoUtil> {
        todoList = mutableListOf<TodoUtil>(
            TodoUtil("Follow AndroidDevs", false),
            TodoUtil("Learn about RecyclerView", true),
            TodoUtil("Feed my cat", false),
            TodoUtil("Prank my boss", false),
            TodoUtil("Eat some curry", false),
            TodoUtil("Ask my crush out", true),
            TodoUtil("Take a shower", false)
        )
        return todoList
    }
    private fun createAdapter() {
        adapter = RecyclerAdapter(createList())
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)
    }

    private fun events() {
        binding.btnAdd.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = TodoUtil(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}