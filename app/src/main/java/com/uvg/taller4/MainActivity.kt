package com.uvg.taller4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition
import  android.widget.LinearLayout



class MainActivity : AppCompatActivity() {

    val items : MutableList<String> = mutableListOf()
    lateinit var agregar : Button
    lateinit var   ly_prueba : LinearLayout
    var tamaño=3


    private  val adaptador= Adaptador({
        clickListener -> showItemClick(clickListener)
    },
            {
                longClickListener -> Update(longClickListener)
            })






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        agregar = findViewById(R.id.agregar)
        //ly_prueba=findViewById(R.id.prueba)


        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")

        adaptador.setitems(items)


        rclView.layoutManager = LinearLayoutManager(this)
        rclView.adapter = adaptador


        agregar.setOnClickListener {
            tamaño++
            items.add("Prueba " + tamaño)

            adaptador.setitems(items)
            rclView.layoutManager = LinearLayoutManager(this)
            rclView.adapter = adaptador

        }

    }
    fun showItemClick(position: Int){

        val item = adaptador.getitems(position)
        items.removeAt(position)
        adaptador.setitems(items)
        rclView.layoutManager= LinearLayoutManager(this)
        rclView.adapter=adaptador


    }

    fun Update(position: Int){
        var item = adaptador.getitems(position)
        items[position]="Modificado"
        adaptador.setitems(items)


    }
}


