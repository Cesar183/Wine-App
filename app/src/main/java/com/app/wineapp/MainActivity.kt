package com.app.wineapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.wineapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: WineListAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapter()
        setupRecyclerView()
    }

    private fun setupAdapter() {
        adapter = WineListAdapter()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
            adapter = this@MainActivity.adapter
        }
    }

    private fun getWine(){
        val wines = getLocalWines()
        adapter.submitList(wines)
    }

    private fun getLocalWines() = listOf(
        Wine("Cursos", "Uva", Rating("4.8","236 ratings"),"Colombia", "https://images.vivino.com/thumbs/GpcSXs2ERS6niDxoAsvESA_pb_x300.png", 1),
        Wine("Castilla", "Cereza", Rating("4.3","236 ratings"),"España", "https://images.vivino.com/thumbs/PBhGMcRNQ7aVnVNr7VgnWA_pb_x300.png", 2),
        Wine("Casillero", "Manzana", Rating("4.2","236 ratings"),"Mexico", "https://images.vivino.com/thumbs/ZzMKzqFqRO-6oI3ys3gGgQ_pb_x300.png", 3),
        Wine("Rivera", "Limon", Rating("4.5","236 ratings"),"Chile", "https://images.vivino.com/thumbs/easjTPIcS-mCQ99XoYOMgQ_pb_x300.png", 4),
        Wine("California", "Lima", Rating("4.1","236 ratings"),"Argentina", "https://images.vivino.com/thumbs/U19RXtSdRMmoAesl2CBygA_pb_x300.png", 5)
    )

    override fun onResume() {
        super.onResume()
        getWine()
    }
}