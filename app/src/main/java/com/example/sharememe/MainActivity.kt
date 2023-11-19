package com.example.sharememe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.sharememe.repository.MainRepository
import com.example.sharememe.retrofit.model.Memes

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar
    private var currentIndex = 0
    private lateinit var memes: List<Memes>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageview)
        progressBar = findViewById(R.id.progressBar)
        loadMeme()
    }

    private fun loadMeme() {
        progressBar.visibility = View.VISIBLE
        memes = MainRepository.getJokes(this)
        Handler().postDelayed(object : Runnable {
            override fun run() {
                Glide.with(this@MainActivity).load(memes[currentIndex].url).into(imageView)
                progressBar.visibility = View.GONE
            }
        }, 3000)
    }


    fun shareMeme(view: View) {


    }

    fun nextMeme(view: View) {
        if (currentIndex < memes.size) {
            currentIndex++
            progressBar.visibility = View.VISIBLE
            Handler().postDelayed(object : Runnable {
                override fun run() {
                    Glide.with(this@MainActivity).load(memes[currentIndex].url).into(imageView)
                    progressBar.visibility = View.GONE
                }
            }, 3000)
        } else {
            Toast.makeText(this, "limit reached!", Toast.LENGTH_LONG).show()
        }
    }
}