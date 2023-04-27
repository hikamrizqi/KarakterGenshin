package com.hikam.karaktergenshin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_KAR ="extra_kar"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgKarakter:ImageView = findViewById(R.id.img_karakter)
        val tvName:TextView = findViewById(R.id.nama_karakter)
        val tvDeskripsi: TextView = findViewById(R.id.profil_karakter)
        val imgVision: ImageView = findViewById(R.id.img_vision)
        val tvVisionName: TextView = findViewById(R.id.nama_vision)
        val tvRegionName: TextView = findViewById(R.id.nama_region)
        val imgRegion: ImageView = findViewById(R.id.img_region)

        val kar = intent.getParcelableExtra<Karakter>(EXTRA_KAR) as Karakter

        Glide.with(this)
            .load(kar.photo)
            .into(imgKarakter)

        tvName.text = kar.name

        Glide.with(this)
            .load(kar.img_vision)
            .into(imgVision)
        tvVisionName.text = kar.vision

        Glide.with(this)
            .load(kar.img_region)
            .into(imgRegion)
        tvRegionName.text = kar.region

        tvDeskripsi.text = kar.description

    }
}