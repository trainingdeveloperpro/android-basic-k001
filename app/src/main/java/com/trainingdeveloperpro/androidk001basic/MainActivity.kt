package com.trainingdeveloperpro.androidk001basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trainingdeveloperpro.androidk001basic.lesson.activity.TestActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Mở sang một activity mới
        startActivity(Intent(this, TestActivity::class.java))
    }
}
