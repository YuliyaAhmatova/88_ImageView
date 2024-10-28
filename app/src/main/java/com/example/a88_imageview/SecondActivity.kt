package com.example.a88_imageview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var imageViewIV:ImageView
    private lateinit var nextPhotoBTN:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageViewIV = findViewById(R.id.imageViewIV)
        nextPhotoBTN = findViewById(R.id.nextPhotoBTN)

        var n = 1

        nextPhotoBTN.setOnClickListener {
            n++
            when(n){
                2 -> imageViewIV.setImageResource(R.drawable.second)
                3 -> imageViewIV.setImageResource(R.drawable.third)
                4 -> imageViewIV.setImageResource(R.drawable.fourd)
                5 -> imageViewIV.setImageResource(R.drawable.fifth)
                else -> {
                    intent = Intent(this, ThirdActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }
        }
    }
}