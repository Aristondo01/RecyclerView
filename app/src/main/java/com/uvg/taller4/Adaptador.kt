package com.uvg.taller4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*

class Adaptador(private val clickListener: (Int) -> Unit,
                private val longClickListener:(Int)-> Unit): RecyclerView.Adapter<Adaptador.ItemsViewHolder>() {
    private  var items: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista,parent,false)
        return ItemsViewHolder(view)

    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item,clickListener,longClickListener)
    }

    override fun getItemCount(): Int {
        return  items.size
    }

    fun setitems(nuevositems: MutableList<String>)
    {
        this.items = nuevositems
        notifyDataSetChanged()
    }

    fun  getitems (position: Int):String
    {
        return  items[position]
    }

    class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(item:String, click: (Int) -> Unit, longClick:(Int) ->Unit) = with(itemView){
            txtTitulo.text = item

            setOnClickListener{
                click(adapterPosition)
            }

            setOnLongClickListener {
                longClick(adapterPosition)
                true
            }
        }
    }

}