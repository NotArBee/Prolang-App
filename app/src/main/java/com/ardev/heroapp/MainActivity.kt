package com.ardev.heroapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var rvProlang: RecyclerView
    private val prolangList = ArrayList<ProgrammingLanguage>()
    private val title = "Top Programming Language"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = title

        rvProlang = findViewById(R.id.rv_prolang)
        rvProlang.setHasFixedSize(true)

        prolangList.addAll(getListProlang())
        showRecyclerList()
    }

    //  function untuk mengambil data di res -> drawable
    private fun getListProlang(): ArrayList<ProgrammingLanguage> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_image)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val listProlang = ArrayList<ProgrammingLanguage>()

        for (i in dataName.indices) {
            val prolang = ProgrammingLanguage(dataName[i], dataDesc[i], dataPhoto.getResourceId(i, -1))
            listProlang.add(prolang)
        }
        return listProlang
    }

    // function untuk menampilkan recyclerview dan menentukan layout recyclerview
    private fun showRecyclerList() {
        rvProlang.layoutManager = LinearLayoutManager(this)
        val listProlangAdapter = ListProlangAdapter(prolangList)
        rvProlang.adapter = listProlangAdapter
    }

    // function untuk menampilkan menu options
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.burger_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Layout ketika dipilih berdasarkan burger menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> rvProlang.layoutManager = LinearLayoutManager(this)
            R.id.action_grid -> rvProlang.layoutManager = GridLayoutManager(this, 2)
            R.id.action_staggered -> rvProlang.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        }
        return super.onOptionsItemSelected(item)
    }
}