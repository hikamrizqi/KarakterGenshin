package com.hikam.karaktergenshin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
    }

    fun openInstagramProfile(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/kamrmm/"))
        startActivity(intent)
    }

    fun openLinkedinProfile(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/hikamrizqillah/"))
        startActivity(intent)
    }

    fun openGithubProfile(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/hikamrizqi"))
        startActivity(intent)
    }
}