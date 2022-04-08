package com.annehasan.plantcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import android.content.Intent




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<Plant>()

        data.add(Plant("Monstera", "Indoor", R.drawable.monstera))
        data.add(Plant("Sansivera", "Indoor", R.drawable.sansivera))
        data.add(Plant("Echeveria", "Outdoor", R.drawable.echeveria))
        data.add(Plant("Gardenia", "Outdoor", R.drawable.gardenia))
        data.add(Plant("Palm", "Outdoor", R.drawable.palm))

        // initialize grid layout manager
        GridLayoutManager(
            this, // context
            2, // span count
            RecyclerView.VERTICAL, // orientation
            false // reverse layout
        ).apply {
            // specify the layout manager for recycler view
            recyclerview.layoutManager = this
        }

        recyclerview.adapter = CustomAdapter(data)
    }
}