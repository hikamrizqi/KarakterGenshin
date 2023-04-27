package com.hikam.karaktergenshin

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKarakter: RecyclerView
    private val list = ArrayList<Karakter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKarakter = findViewById(R.id.rv_genshinchar)
        rvKarakter.setHasFixedSize(true)

        list.addAll(getListKarakter)
        showRecyclerList()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutMe::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private val getListKarakter : ArrayList<Karakter>
    get() {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_genshinchar_image)
        val dataVision = resources.getStringArray(R.array.data_vision)
        val dataImgVision = resources.obtainTypedArray(R.array.data_vision_image)
        val dataRegion = resources.getStringArray(R.array.data_nama_region)
        val dataImgRegion = resources.obtainTypedArray(R.array.data_region_image)
        val getlistKarakter = ArrayList<Karakter>()

        for (i in dataName.indices) {
            val karakter = Karakter(
                dataName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i,-1),
                dataVision[i],
                dataImgVision.getResourceId(i,-1),
                dataRegion[i],
                dataImgRegion.getResourceId(i,-1))
            getlistKarakter.add(karakter)
        }

        return getlistKarakter
    }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvKarakter.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvKarakter.layoutManager = LinearLayoutManager(this)
        }

        val listKarAdapter = ListKarAdapter(list)
        rvKarakter.adapter = listKarAdapter

        listKarAdapter.setOnItemClickCallback(object : ListKarAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Karakter) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(karakter: Karakter) {
        val kar = Karakter(
            karakter.name,
            karakter.description,
            karakter.photo,
            karakter.vision,
            karakter.img_vision,
            karakter.region,
            karakter.img_region
        )

        val detailActivity = Intent(this@MainActivity, DetailActivity::class.java)
        detailActivity.putExtra(DetailActivity.EXTRA_KAR, kar)
        startActivity(detailActivity)
    }
}