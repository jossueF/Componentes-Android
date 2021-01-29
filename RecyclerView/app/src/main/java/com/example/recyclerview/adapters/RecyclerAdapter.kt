package com.example.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ItemRecyclerBinding

// El trabajo del adapter es crear views para nuestro recylerview
// Cada adapter de un recyclerview necesita una clase interna de tipo ViewHolder
// Este adapter de algun modo necesita saber que información debe poner en cada item, para decirle
// ésto al adapter, necesitamos pasar al constructor la lista de información y configurar los datos de la lista
// con el correspondiente item.
// El siguiente paso es implementar tres funciones que cada recyclerview adapter debe tener
class RecyclerAdapter(var todos: List<TodoUtil>) : RecyclerView.Adapter<RecyclerAdapter.TodoViewHolder>(){


    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemRecyclerBinding
        //val txtTitle: TextView
        //val cbDone: CheckBox
        init {
            //txtTitle = itemView.findViewById(R.id.txtTitle)
            //cbDone = itemView.findViewById(R.id.cbDone)
            binding = ItemRecyclerBinding.bind(itemView)
        }
    }

    // Ésta funcion es llamada cuando el recyclerview necesita un nuevo viewholder, por ejemplo si el usuario
    // scrolls un poco, un item es reciclado y necesita crear un nuevo item visible
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return TodoViewHolder(view)
    }

    // El proposito de ésta función es unir la información con nuestros items, esta funcion la usaremos para
    // tomar información de nuestra lista y asignaral a nuestra vista correspondiente (item).
    // Ésta función sera llamada por cada item
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.txtTitle.text = todos[position].title
        holder.binding.cbDone.isChecked = todos[position].isChecked
    }

    // Ésta función retorna cuantos items tenemos en nuestro recyclerview
    override fun getItemCount(): Int {
        return todos.size
    }
}