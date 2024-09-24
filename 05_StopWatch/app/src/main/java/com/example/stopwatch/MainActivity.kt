package com.example.stopwatch

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() , View.OnClickListener{

    private lateinit var btn_start : Button
    private lateinit var btn_restart : Button
    private lateinit var tv_minute : TextView
    private lateinit var tv_second : TextView
    private lateinit var tv_millisecond : TextView

    private val isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn_start = findViewById(R.id.button_start)
        btn_restart = findViewById(R.id.button_restart)
        tv_minute = findViewById(R.id.tv_minute)
        tv_second = findViewById(R.id.tv_second)
        tv_millisecond = findViewById(R.id.tv_millisecond)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.button_start -> {
                if (isRunning) {
                    pause()
                } else {
                    start()
                }
            }

            R.id.button_restart -> {
                restart()
            }
        }
    }

    private fun start() {

    }

    private fun pause() {

    }

    private fun restart() {

    }
}